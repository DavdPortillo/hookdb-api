package com.winningstation.services;

import com.winningstation.entity.VendorProduct;
import com.winningstation.repository.VendorProductRepository;
import com.winningstation.services.interfaces.IVendorProductService;
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
public class VendorProductService implements IVendorProductService {

  /** Logger de la clase. */
  private static final Logger LOGGER = LoggerFactory.getLogger(VendorProductService.class);

  /** Repositorio de la entidad LogoProduct. */
  private final VendorProductRepository vendorProductRepository;

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param vendorProductRepository Repositorio de la entidad LogoProduct.
   */
  public VendorProductService(
          VendorProductRepository vendorProductRepository, FileStorageService fileStorageService) {
    this.vendorProductRepository = vendorProductRepository;
    this.fileStorageService = fileStorageService;
  }

  @Override
  public VendorProduct save(VendorProduct logo, MultipartFile file) {
    LOGGER.info("Guardando logo de producto: {}", logo);
    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    logo.setLogo(fileDownloadUri);
    return vendorProductRepository.save(logo);
  }

  @Override
  public VendorProduct findById(Long id) {
    if (vendorProductRepository.findById(id).isPresent()) {
      return vendorProductRepository.findById(id).get();
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public List<VendorProduct> findAll() {
    return vendorProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    if (vendorProductRepository.existsById(id)) {
      vendorProductRepository.deleteById(id);
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public VendorProduct update(Long id, VendorProduct newVendorProduct, MultipartFile file) {
    VendorProduct existingVendorProduct = vendorProductRepository.findById(id).orElse(null);
    if (existingVendorProduct != null) {
      LOGGER.info("Actualizando logo de producto con id: {}", id);
      if (file != null) {
        String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, existingVendorProduct.getLogo());
        existingVendorProduct.setLogo(fileDownloadUri);
      }
      if (newVendorProduct.getAlt() != null) {
        existingVendorProduct.setAlt(newVendorProduct.getAlt());
      }

      if (newVendorProduct.getName() != null) {
        existingVendorProduct.setName(newVendorProduct.getName());
      }

      return vendorProductRepository.save(existingVendorProduct);
    } else {
      LOGGER.error("No se encontró el logo de producto con id: {}", id);
      throw new RuntimeException("No se encontró el logo de producto con id: " + id);
    }
  }

  @Override
  public List<VendorProduct> findByName(String name) {
    return vendorProductRepository.findByNameContaining(name);
  }
}
