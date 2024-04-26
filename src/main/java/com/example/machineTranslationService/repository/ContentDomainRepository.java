package com.example.machineTranslationService.repository;

import com.example.machineTranslationService.model.ContentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentDomainRepository extends JpaRepository<ContentDomain, Integer> {
    Optional<ContentDomain> findByDomain(String domain);
}
