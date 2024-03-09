package com.winningstation.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.winningstation.constant.ConstantKey;
import com.winningstation.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

/**
 * Clase JwtTokenUtil que se encarga de generar y validar el token de acceso.
 *
 * @author David Portillo Hoyos
 */
@Component
public class JwtTokenUtil {
	// Duración del token de acceso
	private static final long EXPIRE_DURATION = 24L * 60 * 60 * 1000 * 30; // 30 days

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

	/**
	 * Válida el token JWT.
	 *
	 * @param token El token JWT.
	 * @return Verdadero si el token es válido, falso en caso contrario.
	 */
	public boolean validateToken(String token) {
		LOGGER.info("Validando token");
		try {
			SecretKey key = Keys.hmacShaKeyFor(ConstantKey.KEY.getBytes(StandardCharsets.UTF_8));
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			LOGGER.info("Token validado exitosamente");
			return true;
		} catch (ExpiredJwtException e) {
			LOGGER.error("Token expirado", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("Token vacío", e);
		} catch (MalformedJwtException e) {
			LOGGER.error("Token mal formado", e);
		} catch (UnsupportedJwtException e) {
			LOGGER.error("Token no soportado", e);
		} catch (io.jsonwebtoken.security.SignatureException e) {
			LOGGER.error("Fallo en la firma", e);
		}
		return false;
	}

	/**
	 * Genera un token JWT para el cliente.
	 *
	 * @param user El cliente.
	 * @return El token JWT.
	 * @throws IllegalStateException Si ocurre un error al generar el token.
	 */
	public String generateToken(User user) {
		LOGGER.info("Generando token para el cliente con ID: {}", user.getId());
		try {
			String role = user.getRole().getId().toString();
			SecretKey key = Keys.hmacShaKeyFor(ConstantKey.KEY.getBytes(StandardCharsets.UTF_8));
			String token = Jwts.builder()
					.setSubject(String.format("%s,%s,%s,%s,%s", user.getId(), user.getUsername(), 
							user.getPassword(), role, user.getEmail()))
					.setIssuer("winng-api").setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
					.signWith(key, SignatureAlgorithm.HS512).compact();
			LOGGER.info("Token generado exitosamente para el cliente con ID: {}", user.getId());
			return token;
		} catch (Exception e) {
			throw new IllegalStateException("Error al generar token", e);
		}
	}

	/**
	 * Obtiene el sujeto del token JWT.
	 *
	 * @param token El token JWT.
	 * @return El sujeto del token.
	 * @throws IllegalStateException Si ocurre un error al obtener el sujeto del
	 *                               token.
	 */
	public String getSubject(String token) {
		LOGGER.info("Obteniendo sujeto del token");
		try {
			String subject = parseClaims(token).getSubject();
			LOGGER.info("Sujeto obtenido exitosamente del token");
			return subject;
		} catch (Exception e) {
			throw new IllegalStateException("Error al obtener sujeto del token", e);
		}
	}

	/**
	 * Este método se encarga de extraer la información contenida en el token JWT.
	 *
	 * @param token El token JWT.
	 * @return La información contenida en el token JWT.
	 * @throws IllegalStateException Si ocurre un error al extraer la información
	 *                               del token.
	 */
	public Claims parseClaims(String token) {
		LOGGER.info("Parseando reclamaciones del token");
		try {
			SecretKey key = Keys.hmacShaKeyFor(ConstantKey.KEY.getBytes(StandardCharsets.UTF_8));
			Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
			LOGGER.info("Reclamaciones parseadas exitosamente del token");
			return claims;
		} catch (Exception e) {
			throw new IllegalStateException("Error al parsear reclamaciones del token", e);
		}
	}
}
