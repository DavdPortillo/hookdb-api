package com.winningstation.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

  public String storeFile(MultipartFile file) {
    try {
      // Genera un nombre de archivo único para cada archivo que se sube
      String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

      // Convierte el MultipartFile en un archivo regular
      byte[] bytes = file.getBytes();
      String uploadDir = "/images";  // Aquí cambiamos la ruta a /images
      Path path = Paths.get(uploadDir + "/" + fileName);
      Files.write(path, bytes);

      // Devuelve el nombre del archivo
      return fileName;
    } catch (IOException e) {
      // Manejar excepción
      throw new RuntimeException("Error al almacenar el archivo", e);
    }
  }
}
