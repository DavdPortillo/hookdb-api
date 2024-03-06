package com.winningstation.services;

import com.winningstation.entity.EditionProduct;
import com.winningstation.repository.EditionProductRepository;
import com.winningstation.services.interfaces.IEditionProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la edición de productos
 *
 * @author David Portillo Hoyos
 */
@Transactional
@Service
public class EditioProductService implements IEditionProductService {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(EditioProductService.class);

  /** Repositorio de edición de productos */
  private final EditionProductRepository editionProductRepository;

  /**
   * Constructor
   *
   * @param editionProductRepository Repositorio de edición de productos
   */
  public EditioProductService(EditionProductRepository editionProductRepository) {
    this.editionProductRepository = editionProductRepository;
  }

  @Override
  public EditionProduct save(EditionProduct editionProduct) {
    return editionProductRepository.save(editionProduct);
  }

  @Override
  public EditionProduct findById(Long id) {
    if (editionProductRepository.findById(id).isPresent()) {
      return editionProductRepository.findById(id).get();
    } else {
      throw new RuntimeException("Edition product not found");
    }
  }

  @Override
  public List<EditionProduct> findAll() {
    return editionProductRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    if (editionProductRepository.findById(id).isPresent()) {
      editionProductRepository.deleteById(id);
    } else {
      throw new RuntimeException("Edition product not found");
    }
  }

  @Override
  public String update(Long id, String name) {

    EditionProduct editionProduct = editionProductRepository.findById(id).orElse(null);
    if (editionProduct != null) {
      editionProduct.setName(name);
      editionProductRepository.save(editionProduct);
      return name;
    } else {
      throw new RuntimeException("Edition product not found");
    }
  }

  @Override
  public List<EditionProduct> findByName(String name) {
    return editionProductRepository.findByNameContaining(name);
  }
}
