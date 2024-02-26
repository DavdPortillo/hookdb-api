package com.winningstation.services.interfaces;

import com.winningstation.entity.Platform;

/**
 * Interface que define los métodos que debe implementar la clase Platform.
 *
 * @author David Portillo Hoyos
 */
public interface IPlatformService {

    /**
     * Método que permite guardar una plataforma.
     *
     * @param platform Plataforma a guardar.
     */
    void save(Platform platform);


}
