package com.winningstation.request;

import lombok.Data;

/**
 * Clase que representa la petición para guardar la disponibilidad de un lenguaje.
 *
 * @author David Portillo Hoyos
 */
@Data
public class AvailabilityRequest {
  private Long id;
  private Long languageId;
  private Boolean interfaceLanguage;
  private Boolean subtitleLanguage;
  private Boolean audioLanguage;
}
