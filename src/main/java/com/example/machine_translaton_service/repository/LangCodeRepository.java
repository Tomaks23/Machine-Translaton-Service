package com.example.machine_translaton_service.repository;

import com.example.machine_translaton_service.model.LangCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LangCodeRepository extends JpaRepository<LangCode, Integer> {
    Optional<LangCode> findByName(String sourceLanguage);

}
