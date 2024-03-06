package com.winningstation.services;

import com.winningstation.entity.KeysProduct;
import com.winningstation.entity.RegionProduct;
import com.winningstation.repository.KeysProductRepository;
import com.winningstation.repository.RegionProductRepository;
import com.winningstation.services.interfaces.IKeysProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la entidad KeysProduct.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class KeysProductService implements IKeysProductService {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(KeysProductService.class);

  /** Repositorio de Keysproduct */
  private final KeysProductRepository keysProductRepository;

  /**
   * Constructor
   *
   * @param keysProductRepository Repositorio de Keysproduct
   */
  public KeysProductService(KeysProductRepository keysProductRepository) {
    this.keysProductRepository = keysProductRepository;
  }

  @Override
  public KeysProduct save(KeysProduct keysProduct) {
    LOGGER.info("Guardando KeysProduct");
    return keysProductRepository.save(keysProduct);
  }

  @Override
  public KeysProduct findById(Long id) {
    LOGGER.info("Obteniendo KeysProduct por id {}", id);
    return keysProductRepository.findById(id).orElse(null);
  }

  @Override
  public List<KeysProduct> findAll() {
    LOGGER.info("Obteniendo todos los KeysProduct");
    return keysProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOGGER.info("Eliminando KeysProduct por id {}", id);
    keysProductRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOGGER.info("Actualizando KeysProduct por id {}", id);
    KeysProduct keysProduct = keysProductRepository.findById(id).orElse(null);
    if (keysProduct != null) {
      keysProduct.setName(request);
      keysProductRepository.save(keysProduct);
      return request;
    } else {
      throw new RuntimeException("No se encontró el registro");
    }
  }

  @Override
  public List<KeysProduct> findByName(String name) {
    LOGGER.info("Obteniendo KeysProduct por nombre {}", name);
    return keysProductRepository.findByNameContaining(name);
  }
}
