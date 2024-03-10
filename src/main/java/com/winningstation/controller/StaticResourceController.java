package com.winningstation.controller;

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

  @GetMapping("/images/{filename:.+}")
  public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

    Resource file = new PathResource(Paths.get("/images/", filename));
    String contentType = getContentType(filename);

    return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(file);
  }

  private String getContentType(String filename) {
    String extension = filename.substring(filename.lastIndexOf(".") + 1);
      return switch (extension.toLowerCase()) {
          case "png" -> "image/png";
          case "jpg", "jpeg" -> "image/jpeg";
          default -> "application/octet-stream";
      };
  }
}
