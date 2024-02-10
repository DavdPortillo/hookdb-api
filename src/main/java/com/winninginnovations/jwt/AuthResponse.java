package com.winninginnovations.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase AuthResponse que representa una respuesta de autenticación.
 * Esta clase se utiliza para enviar los detalles del usuario después de un inicio de sesión exitoso.
 *
 * @author David Portillo Hoyos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    /**
     * El ID del usuario.
     */
    private Long id;

    /**
     * El nombre del usuario.
     */
    private String name;

    /**
     * El apellido del usuario.
     */
    private String surname;

    /**
     * El correo electrónico del usuario.
     */
    private String email;

    /**
     * La contraseña del usuario.
     */
    private String password;

    /**
     * El rol del usuario.
     */
    private String role;

    /**
     * El token de acceso del usuario.
     */
    private String accessToken;

}

