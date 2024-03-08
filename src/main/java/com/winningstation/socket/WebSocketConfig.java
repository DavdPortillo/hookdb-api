package com.winningstation.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

  private final AvgScoreSocketHandler avgScoreSocketHandler;
  private final AvgScore100SocketHandler avgScore100SocketHandler;

  private final ReviewVotesSocketHandler reviewVotesSocketHandler;

  public WebSocketConfig(
      AvgScoreSocketHandler avgScoreSocketHandler,
      AvgScore100SocketHandler avgScore100SocketHandler,
      ReviewVotesSocketHandler reviewVotesSocketHandler) {
    this.avgScoreSocketHandler = avgScoreSocketHandler;
    this.avgScore100SocketHandler = avgScore100SocketHandler;
    this.reviewVotesSocketHandler = reviewVotesSocketHandler;
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(avgScoreSocketHandler, "/avg-score/{gameId}").setAllowedOrigins("*");
    registry.addHandler(avgScore100SocketHandler, "/avg-score-100/{gameId}").setAllowedOrigins("*");
    registry.addHandler(reviewVotesSocketHandler, "/review-votes/{reviewId}").setAllowedOrigins("*");

  }
}
