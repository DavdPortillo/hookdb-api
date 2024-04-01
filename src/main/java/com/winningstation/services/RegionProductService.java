package com.winningstation.services;

import com.winningstation.entity.RegionProduct;
import com.winningstation.repository.RegionProductRepository;
import com.winningstation.services.interfaces.IRegionProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la entidad RegionProduct.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class RegionProductService implements IRegionProductService {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(RegionProductService.class);

  /** Repositorio de RegionProduct */
  private final RegionProductRepository regionProductRepository;

  /**
   * Constructor
   *
   * @param regionProductRepository Repositorio de RegionProduct
   */
  public RegionProductService(RegionProductRepository regionProductRepository) {
    this.regionProductRepository = regionProductRepository;
  }

  @Override
  public RegionProduct save(RegionProduct regionProduct) {
    LOGGER.info("Guardando RegionProduct {}", regionProduct);
    return regionProductRepository.save(regionProduct);
  }

  @Override
  public RegionProduct findById(Long id) {
    LOGGER.info("Obteniendo RegionProduct por id {}", id);
    return regionProductRepository.findById(id).orElse(null);
  }

  @Override
  public List<RegionProduct> findAll() {
    LOGGER.info("Obteniendo todos los RegionProduct");
    return regionProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOGGER.info("Eliminando RegionProduct por id {}", id);
    regionProductRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOGGER.info("Actualizando RegionProduct por id {}", id);
    RegionProduct regionProduct = regionProductRepository.findById(id).orElse(null);
    if (regionProduct != null) {
      regionProduct.setName(request);
      regionProductRepository.save(regionProduct);
      return request;
    } else {
      throw new RuntimeException("Registro no encontrado");
    }
  }

  @Override
  public List<RegionProduct> findByName(String name) {
    LOGGER.info("Obteniendo RegionProduct por nombre {}", name);
    return regionProductRepository.findByNameContaining(name);
  }
}
