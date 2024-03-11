package com.winningstation.services;

import com.winningstation.entity.LogoProduct;
import com.winningstation.repository.LogoProductRepository;
import com.winningstation.services.interfaces.ILogoProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre los logos de los productos.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class LogoProductService implements ILogoProductService {

  /** Logger de la clase. */
  private static final Logger LOGGER = LoggerFactory.getLogger(LogoProductService.class);

  /** Repositorio de la entidad LogoProduct. */
  private final LogoProductRepository logoProductRepository;

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param logoProductRepository Repositorio de la entidad LogoProduct.
   */
  public LogoProductService(
      LogoProductRepository logoProductRepository, FileStorageService fileStorageService) {
    this.logoProductRepository = logoProductRepository;
    this.fileStorageService = fileStorageService;
  }

  @Override
  public LogoProduct save(LogoProduct logo, MultipartFile file) {
    LOGGER.info("Guardando logo de producto: {}", logo);
    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    logo.setLogo(fileDownloadUri);
    return logoProductRepository.save(logo);
  }

  @Override
  public LogoProduct findById(Long id) {
    if (logoProductRepository.findById(id).isPresent()) {
      return logoProductRepository.findById(id).get();
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public List<LogoProduct> findAll() {
    return logoProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    if (logoProductRepository.existsById(id)) {
      logoProductRepository.deleteById(id);
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public LogoProduct update(Long id, LogoProduct newLogoProduct, MultipartFile file) {
    LogoProduct existingLogoProduct = logoProductRepository.findById(id).orElse(null);
    if (existingLogoProduct != null) {
      LOGGER.info("Actualizando logo de producto con id: {}", id);
      if (file != null) {
        String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, existingLogoProduct.getLogo());
        existingLogoProduct.setLogo(fileDownloadUri);
      }
      if (newLogoProduct.getAlt() != null) {
        existingLogoProduct.setAlt(newLogoProduct.getAlt());
      }
      return logoProductRepository.save(existingLogoProduct);
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public List<LogoProduct> findByName(String name) {
    return logoProductRepository.findByLogoContaining(name);
  }
}
