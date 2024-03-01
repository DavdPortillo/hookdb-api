package com.winningstation.request;

import lombok.Data;

/**
 * Clase que representa la petición para guardar un producto.
 *
 * @author David Portillo Hoyos
 */
@Data
public class ProductRequest {
    private Long id;
  private Double price;
  private String link;
  private Long logoProductId;
  private Long editionProductId;
  private Long platformProductId;
  private Long vendorProductId;
  private Long regionProductId;
  private Long keysProductId;
}
