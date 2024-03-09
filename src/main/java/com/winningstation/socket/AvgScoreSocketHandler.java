package com.winningstation.socket;

import com.winningstation.dto.ScoreAverageResultDTO;
import com.winningstation.services.interfaces.IGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

@Service
public class AvgScoreSocketHandler extends TextWebSocketHandler {

  private final IGameService gameService;
  private final Map<Long, Set<WebSocketSession>> gameSessions = new HashMap<>();

  private static final Logger LOGGER = LoggerFactory.getLogger(AvgScoreSocketHandler.class);

  public AvgScoreSocketHandler(IGameService gameService) {
    this.gameService = gameService;
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    Long gameId = Long.parseLong(Objects.requireNonNull(session.getUri()).getPath().split("/")[2]);
    gameSessions.computeIfAbsent(gameId, k -> new HashSet<>()).add(session);
    LOGGER.info("Conexión WebSocket establecida para el juego con ID {}", gameId);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    Long gameId = Long.parseLong(Objects.requireNonNull(session.getUri()).getPath().split("/")[2]);
    Set<WebSocketSession> sessions = gameSessions.get(gameId);
    if (sessions != null) {
      sessions.remove(session);
    }
    LOGGER.info("Conexión WebSocket cerrada para el juego con ID {}", gameId);
  }

  public void sendScoreToGameSessions(Long gameId) {
    Set<WebSocketSession> sessions = gameSessions.get(gameId);
    if (sessions != null) {
      try {
        ScoreAverageResultDTO averageScore = gameService.calculateAverageScore(gameId);
        for (WebSocketSession session : sessions) {
          session.sendMessage(new TextMessage(averageScore.toString()));
        }
        LOGGER.info("Se envió la puntuación media a las sesiones del juego con ID {}", gameId);
      } catch (IOException e) {
        LOGGER.error("Error al enviar la puntuación media a las sesiones", e);
      }
    }
  }

  @Scheduled(fixedRate = 10000)
  public void pingSessions() {
    gameSessions.values().forEach(sessions -> {
      sessions.forEach(session -> {
        if (session.isOpen()) {
          try {
            session.sendMessage(new PingMessage());
          } catch (IOException e) {
            LOGGER.error("Error al enviar el mensaje Ping", e);
          }
        }
      });
    });
  }
}
