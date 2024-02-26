package com.winningstation.services.interfaces;

import com.winningstation.entity.Distributor;

/**
 * Interfaz que define los métodos que se pueden realizar sobre un distribuidor.
 *
 * @author David Portillo Hoyos
 */
public interface IDistributorService {

    /**
     * Método que guarda un distribuidor en la base de datos.
     *
     * @param distributor Distribuidor a guardar.
     * @return Distribuidor guardado.
     */
    Distributor save(Distributor distributor);
}
