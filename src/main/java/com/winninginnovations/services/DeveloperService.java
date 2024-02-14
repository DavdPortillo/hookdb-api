package com.winninginnovations.services;

import com.winninginnovations.entity.Developer;
import com.winninginnovations.repository.DeveloperRepository;
import com.winninginnovations.services.interfaces.IDeveloperService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeveloperService implements IDeveloperService {


    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DeveloperService.class);

    /**
     * Repositorio de developer.
     */
    private final DeveloperRepository developerRepository;

    /**
     * Constructor de la clase.
     *
     * @param developerRepository Repositorio de developer.
     */
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }


    /**
     * Guarda un developer.
     *
     * @param developer Developer de juego a guardar.
     * @return Developer guardado.
     */
    public Developer save(Developer developer) {
        LOG.info("Saving developer: {}", developer);
        developerRepository.save(developer);
        return developer;
    }

}
