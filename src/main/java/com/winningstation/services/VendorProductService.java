package com.winningstation.services;

import com.winningstation.entity.PlatformProduct;
import com.winningstation.entity.VendorProduct;
import com.winningstation.repository.PlatformProductRepository;
import com.winningstation.repository.VendorProductRepository;
import com.winningstation.services.interfaces.IVendorProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la entidad VendorProduct.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class VendorProductService implements IVendorProductService {
  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(VendorProductService.class);

  /** Repositorio de VendorProduct */
  private final VendorProductRepository vendorProductRepository;

  /**
   * Constructor
   *
   * @param vendorProductRepository Repositorio de VendorProduct
   */
  public VendorProductService(VendorProductRepository vendorProductRepository) {
    this.vendorProductRepository = vendorProductRepository;
  }

  @Override
  public VendorProduct save(VendorProduct vendorProduct) {
    LOGGER.info("Guardando VendorProduct {}", vendorProduct);
    return vendorProductRepository.save(vendorProduct);
  }

  @Override
  public VendorProduct findById(Long id) {
    LOGGER.info("Obteniendo VendorProduct por id {}", id);
    return vendorProductRepository.findById(id).orElse(null);
  }

  @Override
  public List<VendorProduct> findAll() {
    LOGGER.info("Obteniendo todos los VendorProduct");
    return vendorProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOGGER.info("Eliminando VendorProduct por id {}", id);
    vendorProductRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOGGER.info("Actualizando VendorProduct por id {}", id);
    VendorProduct vendorProduct = vendorProductRepository.findById(id).orElse(null);
    if (vendorProduct != null) {
      vendorProduct.setName(request);
      vendorProductRepository.save(vendorProduct);
      return request;
    } else {
      throw new RuntimeException("Registro no encontrado");
    }
  }

  @Override
  public List<VendorProduct> findByName(String name) {
    LOGGER.info("Obteniendo VendorProduct por nombre {}", name);
    return vendorProductRepository.findByNameContaining(name);
  }
}
