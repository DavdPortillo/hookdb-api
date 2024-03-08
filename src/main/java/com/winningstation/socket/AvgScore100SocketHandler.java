package com.winningstation.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winningstation.dto.ScoreAverageResultDTO;
import com.winningstation.services.interfaces.IGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

@Service
public class AvgScore100SocketHandler extends TextWebSocketHandler {

  private final IGameService gameService;
  private final Map<Long, Set<WebSocketSession>> gameSessions = new HashMap<>();

  public AvgScore100SocketHandler(IGameService gameService) {
    this.gameService = gameService;
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(AvgScore100SocketHandler.class);

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    try {
      Long gameId = Long.parseLong(Objects.requireNonNull(session.getUri()).getPath().split("/")[2]);
      gameSessions.computeIfAbsent(gameId, k -> new HashSet<>()).add(session);
      LOGGER.info("Conexión WebSocket establecida para el juego con ID {}", gameId);
    } catch (Exception e) {
      LOGGER.error("Error al establecer la conexión WebSocket", e);
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    try {
      Long gameId = Long.parseLong(Objects.requireNonNull(session.getUri()).getPath().split("/")[2]);
      Set<WebSocketSession> sessions = gameSessions.get(gameId);
      if (sessions != null) {
        sessions.remove(session);
      }
      LOGGER.info("Conexión WebSocket cerrada para el juego con ID {}", gameId);
    } catch (Exception e) {
      LOGGER.error("Error al cerrar la conexión WebSocket", e);
    }
  }

  public void sendLast100ScoresUpdate(Long gameId) {
    Set<WebSocketSession> sessions = gameSessions.get(gameId);
    if (sessions != null) {
      try {
        List<ScoreAverageResultDTO> last100Scores = gameService.calculateAverageScoreOfLast100(gameId);
        String last100ScoresJson = new ObjectMapper().writeValueAsString(last100Scores);
        for (WebSocketSession session : sessions) {
          session.sendMessage(new TextMessage(last100ScoresJson));
        }
        LOGGER.info("Se enviaron las últimas 100 puntuaciones a las sesiones del juego con ID {}", gameId);
      } catch (IOException e) {
        LOGGER.error("Error al enviar las últimas 100 puntuaciones a las sesiones", e);
      }
    }
  }
}