package com.winningstation.request;

import lombok.Data;

import java.util.List;

/**
 * Clase que representa la petición para guardar un lenguaje.
 *
 * @author David Portillo Hoyos
 */
@Data
public class LanguageRequest {
    private Long id;
    private List<AvailabilityRequest> availabilities;
}