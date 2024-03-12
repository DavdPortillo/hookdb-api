package com.winningstation.repository;

import com.winningstation.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {

  List<Translation> findByLanguageContaining(String name);
}
