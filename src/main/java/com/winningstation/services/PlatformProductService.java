package com.winningstation.services;

import com.winningstation.entity.EditionProduct;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.repository.EditionProductRepository;
import com.winningstation.repository.PlatformProductRepository;
import com.winningstation.services.interfaces.IPlatformProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la entidad PlatformProduct.
 *
 * @author David Portillo Hoyos
 */
@Transactional
@Service
public class PlatformProductService implements IPlatformProductService {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(PlatformProductService.class);

  /** Repositorio de edición de productos */
  private final PlatformProductRepository platformProductRepository;

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param platformProductRepository Repositorio de edición de productos.
   */
  public PlatformProductService(
      PlatformProductRepository platformProductRepository, FileStorageService fileStorageService) {
    this.platformProductRepository = platformProductRepository;
    this.fileStorageService = fileStorageService;
  }

  @Override
  public PlatformProduct save(PlatformProduct platformProduct, MultipartFile file) {
    LOGGER.info("Guardando plataforma");
    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    platformProduct.setImage(fileDownloadUri);
    return platformProductRepository.save(platformProduct);
  }

  @Override
  public PlatformProduct findById(Long id) {
    LOGGER.info("Obteniendo plataforma por id {}", id);
    if (platformProductRepository.findById(id).isPresent()) {
      return platformProductRepository.findById(id).get();
    } else {
      throw new RuntimeException("Platform product not found");
    }
  }

  @Override
  public List<PlatformProduct> findAll() {
    LOGGER.info("Obteniendo todas las plataformas");
    return platformProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOGGER.info("Eliminando plataforma por id {}", id);
    platformProductRepository.deleteById(id);
  }

  @Override
  public PlatformProduct update(Long id, PlatformProduct request, MultipartFile file) {
    LOGGER.info("Actualizando plataforma por id {}", id);
    PlatformProduct platformProduct = findById(id);
    if (platformProduct == null) {
      throw new RuntimeException("Platform product not found");
    }
    if (request.getName() != null) {
      platformProduct.setName(request.getName());
    }
    if (file != null) {
      String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, platformProduct.getImage());
      platformProduct.setImage(fileDownloadUri);
    }
    if (request.getAlt() != null) {
      platformProduct.setAlt(request.getAlt());
    }
    return platformProductRepository.save(platformProduct);
  }

  @Override
  public List<PlatformProduct> findByName(String name) {
    LOGGER.info("Obteniendo plataforma por nombre {}", name);
    return platformProductRepository.findByNameContaining(name);
  }
}
