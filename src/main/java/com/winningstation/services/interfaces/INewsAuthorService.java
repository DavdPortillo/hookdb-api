package com.winningstation.services.interfaces;

import com.winningstation.entity.NewsAuthor;
import com.winningstation.entity.PlatformProduct;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase NewsAuthor.
 *
 * @author David Portillo Hoyos
 */
public interface INewsAuthorService {

  /**
   * Método que permite obtener un autor por su ID.
   *
   * @param id ID del autor.
   * @return El autor con el ID especificado.
   */
  NewsAuthor findById(Long id);

  /**
   * Método que permite guardar un autor.
   *
   * @param newsAuthor Autor a guardar.
   * @return El autor guardado.
   */
  NewsAuthor save(NewsAuthor newsAuthor, MultipartFile file);

  /**
   * Método que permite eliminar un autor.
   *
   * @param id id del autor a eliminar.
   */
  void delete(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<NewsAuthor> findAll();

  /**
   * Método que permite actualizar
   *
   * @param id Id a actualizar.
   * @param request Plataforma a actualizar.
   * @return la plataforma actualizada.
   */
  NewsAuthor update(Long id, NewsAuthor request, MultipartFile file);

  /**
   * Método que permite obtener registros por su nombre.
   *
   * @param name Nombre a obtener.
   * @return La plataforma obtenida.
   */
  List<NewsAuthor> findByName(String name);
}
