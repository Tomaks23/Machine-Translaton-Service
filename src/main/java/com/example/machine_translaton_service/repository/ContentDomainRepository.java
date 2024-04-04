package com.example.machine_translaton_service.repository;

import com.example.machine_translaton_service.model.ContentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentDomainRepository extends JpaRepository<ContentDomain, Integer> {
    Optional<ContentDomain> findByDomain(String domain);
}
