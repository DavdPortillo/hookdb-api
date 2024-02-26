package com.winningstation.jwt;

import lombok.Data;

/**
 * Clase AuthRequest que representa una solicitud de autenticación.
 * Esta clase se utiliza para capturar los datos de inicio de sesión del usuario.
 *
 * @author David Portillo Hoyos
 */
@Data
public class AuthRequest {

    /**
     * El correo electrónico del usuario.
     */
    private String email;

    /**
     * La contraseña del usuario.
     */
    private String password;

}
