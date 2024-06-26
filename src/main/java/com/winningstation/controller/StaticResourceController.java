package com.winningstation.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@RestController
public class StaticResourceController {

  @Operation(summary = "Sirve una imagen", description = "Sirve una imagen estática del servidor.")
  @GetMapping("/app/images/{filename:.+}")
  public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

    Resource file = new PathResource(Paths.get("/app/images/", filename));
    String contentType = getContentType(filename);

    return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(file);
  }

  private String getContentType(String filename) {
    String extension = filename.substring(filename.lastIndexOf(".") + 1);
    return switch (extension.toLowerCase()) {
      case "png" -> "image/png";
      case "jpg", "jpeg" -> "image/jpeg";
      case "webp" -> "image/webp";
      case "gif" -> "image/gif";
      default -> "application/octet-stream";
    };
  }
}
