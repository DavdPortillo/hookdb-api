package com.winninginnovations.request;

import lombok.Data;

/**
 * Clase que representa la petición para guardar la disponibilidad de un lenguaje.
 *
 * @author David Portillo Hoyos
 */
@Data
public class AvailabilityRequest {
  private Long languageId;
  private String interfaceLanguage;
  private String subtitleLanguage;
  private String audioLanguage;
}
