package com.winningstation.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winningstation.services.interfaces.IReviewService;
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
public class ReviewVotesSocketHandler extends TextWebSocketHandler {

  private final IReviewService reviewService;
  private final Map<Long, Set<WebSocketSession>> reviewSessions = new HashMap<>();

  private static final Logger logger = LoggerFactory.getLogger(ReviewVotesSocketHandler.class);

  public ReviewVotesSocketHandler(IReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    String path = Objects.requireNonNull(session.getUri()).getPath();
    String[] segments = path.split("/");
    if (segments.length > 2) {
      Long reviewId = Long.parseLong(segments[2]);
      reviewSessions.computeIfAbsent(reviewId, k -> new HashSet<>()).add(session);
    } else {
        throw new IllegalStateException("La URI de la sesión WebSocket no tiene suficientes segmentos");
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    String path = Objects.requireNonNull(session.getUri()).getPath();
    String[] segments = path.split("/");
    if (segments.length > 2) {
      Long reviewId = Long.parseLong(segments[2]);
      Set<WebSocketSession> sessions = reviewSessions.get(reviewId);
      if (sessions != null) {
        sessions.remove(session);
      }
    } else {
      throw new IllegalStateException("La URI de la sesión WebSocket no tiene suficientes segmentos");
    }
  }


  public void sendReviewVotesUpdate(Long reviewId) {
    Set<WebSocketSession> sessions = reviewSessions.get(reviewId);
    if (sessions != null) {
      Map<String, Integer> reviewVotes = reviewService.getReviewVotes(reviewId);
      String reviewVotesJson;
      try {
        // Convertir el mapa a JSON
        reviewVotesJson = new ObjectMapper().writeValueAsString(reviewVotes);
      } catch (JsonProcessingException e) {
        logger.error("Error al convertir los votos de la revisión a JSON", e);
        return;
      }
      TextMessage message = new TextMessage(reviewVotesJson);
      for (WebSocketSession session : sessions) {
        try {
          session.sendMessage(message);
        } catch (IOException e) {
          logger.error("Error al enviar el mensaje a la sesión WebSocket", e);
        }
      }
      logger.info("Se envió la actualización de votos de la revisión {} a {} sesiones", reviewId, sessions.size());
    } else {
      logger.info("No hay sesiones para enviar la actualización de votos de la revisión {}", reviewId);
    }
  }
}


