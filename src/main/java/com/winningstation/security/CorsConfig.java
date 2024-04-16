package com.winningstation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase que configura el CORS para permitir las peticiones desde el cliente
 *
 * @author David Portillo Hoyos
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configura las asignaciones de CORS.
     * Este método se utiliza para definir qué orígenes, métodos, etc. están permitidos en las solicitudes CORS.
     *
     * @param registry El registro de CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite solicitudes CORS a todas las rutas (/**) desde el origen http://localhost:5173
        // y permite los métodos GET, POST, PUT y DELETE.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173/","http://localhost:5174/","http://localhost:3000/","http://158.179.219.214","http://158.179.219.214:30890","https://hookdb.davidportillo.live")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
