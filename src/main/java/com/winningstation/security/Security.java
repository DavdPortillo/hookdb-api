package com.winningstation.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.winningstation.jwt.JwtTokenFilter;

import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase que configura la seguridad de la aplicación
 *
 * @author David Portillo Hoyos
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class Security {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(Security.class);


  /**
   * Configura el codificador de contraseñas.
   *
   * @return El codificador de contraseñas.¶
   */
  @Bean
  BCryptPasswordEncoder passwordEncoder() {
    LOGGER.info("Configurando el codificador de contraseñas");
    return new BCryptPasswordEncoder();
  }

  /**
   * Configura la cadena de filtros de seguridad.
   *
   * @param http La configuración de seguridad HTTP.
   * @return La cadena de filtros de seguridad.
   * @throws Exception si ocurre un error al configurar la cadena de filtros de seguridad.
   */
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http, JwtTokenFilter jwtTokenFilter)
      throws Exception {
    LOGGER.info("Configurando la cadena de filtros de seguridad");
    http.csrf(csrf -> csrf.disable());
    http.sessionManagement(
        management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.exceptionHandling(
        handling ->
            handling.authenticationEntryPoint(
                (req, rsp, e) -> {
                  LOGGER.error("Error de autenticación", e);
                  rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }));
    http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    http.authorizeHttpRequests(
        auth ->
            auth.requestMatchers(
                    HttpMethod.POST,
                    "/developer/**",
                    "/user/**",
                    "/distributor/**",
                    "/dlc/**",
                    "/edition-product/**",
                    "/feature/**")
                .hasRole("ADMIN_ROLE")
                .requestMatchers(
                    HttpMethod.DELETE,
                    "/developer/**",
                    "/user/**",
                    "/distributor/**",
                    "/dlc/**",
                    "/edition-product/**",
                    "/feature/**")
                .hasRole("ADMIN_ROLE")
                .requestMatchers(
                    HttpMethod.GET,
                    "/developer/**",
                    "/user/**",
                    "/distributor/**",
                    "/dlc/**",
                    "/edition-product/**",
                    "/feature/**")
                .hasRole("ADMIN_ROLE")
                .requestMatchers(
                    HttpMethod.PUT,
                    "/developer/**",
                    "/user/**",
                    "/distributor/**",
                    "/dlc/**",
                    "/edition-product/**",
                    "/feature/**")
                .hasRole("ADMIN_ROLE")
                .requestMatchers(
                    HttpMethod.POST, "/user/{userId}/game/{gameId}/followOrIgnore/{action}")
                .authenticated()
                .requestMatchers(
                    HttpMethod.GET,
                    "/userId/{userId}/followedOrIgnoreGames",
                    "/userId/{userId}/ignoredGames",
                    "/userId/{userId}/followedGames",
                    "/userId/{userId}/game/{gameId}")
                .authenticated()
                .anyRequest()
                .permitAll());

    LOGGER.info("Cadena de filtros de seguridad configurada exitosamente");
    return http.build();
  }
}

// http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/booking-history")
//				.hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.GET, SecurityConstants.BOOKING_HISTORY_ID_URL).authenticated()
//				.requestMatchers(HttpMethod.DELETE, SecurityConstants.BOOKING_HISTORY_ID_URL)
//				.hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.POST,
// "/booking-history/{clientId}/{teleportationId}/{timeTravelId}")
//				.hasRole(SecurityConstants.ADMIN_ROLE)
//
//				.requestMatchers(HttpMethod.PUT, SecurityConstants.BOOKING_HISTORY_ID_URL)
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.PUT,
// SecurityConstants.CLIENT_ID_URL)
//				.authenticated().requestMatchers(HttpMethod.DELETE, SecurityConstants.CLIENT_ID_URL)
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.GET, "/client")
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.GET, "/client/search")
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.GET,
// SecurityConstants.CLIENT_ID_URL)
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.POST, "/news")
//				.hasRole(SecurityConstants.ADMIN_ROLE).requestMatchers(HttpMethod.DELETE,
// "/news/{id}").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.PUT, "/news/{id}").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.POST, "/teleportation").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.DELETE,
// "/teleportation/{id}").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.PUT, "/teleportation/{id}").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.POST, "/timetravel").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.DELETE, "/timetravel/{id}").hasRole(SecurityConstants.ADMIN_ROLE)
//				.requestMatchers(HttpMethod.PUT,
// "/timetravel/{id}").hasRole(SecurityConstants.ADMIN_ROLE).anyRequest()
//				.permitAll());
