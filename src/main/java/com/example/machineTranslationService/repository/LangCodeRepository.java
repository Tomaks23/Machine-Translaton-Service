package com.example.machineTranslationService.repository;

import com.example.machineTranslationService.model.LangCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LangCodeRepository extends JpaRepository<LangCode, Integer> {
    Optional<LangCode> findByName(String sourceLanguage);

}
