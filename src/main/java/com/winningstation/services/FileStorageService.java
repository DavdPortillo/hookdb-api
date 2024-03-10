package com.winningstation.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Clase que implementa el servicio para el almacenamiento de archivos.
 *
 * @author David Portillo Hoyos
 */
@Service
public class FileStorageService {
  private static final List<String> CONTENT_TYPES =
      Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif", "image/webp");

  public String storeFile(MultipartFile file) {
    try {
      // Verifica si el archivo es una imagen
      String contentType = file.getContentType();
      if (contentType == null || !CONTENT_TYPES.contains(contentType)) {
        throw new RuntimeException("Error: solo se permiten archivos de imagen.");
      }

      // Genera un nombre de archivo único para cada archivo que se sube
      String fileName = UUID.randomUUID().toString();

      // Convierte el MultipartFile en un archivo regular
      byte[] bytes = file.getBytes();
      String uploadDir = "/app/images";
      Path dirPath = Paths.get(uploadDir);
      if (!Files.exists(dirPath)) {
        Files.createDirectories(dirPath); // Crea el directorio si no existe
      }
      Path path = dirPath.resolve(fileName);
      Files.write(path, bytes);

      // Devuelve el nombre del archivo
      return fileName;
    } catch (IOException e) {
      // Manejar excepción
      throw new RuntimeException("Error al almacenar el archivo", e);
    }
  }

  public String storeFileAndGenerateUri(MultipartFile file) {
    String fileName = storeFile(file);
    return ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/app/images/")
        .path(fileName)
        .toUriString();
  }
}
