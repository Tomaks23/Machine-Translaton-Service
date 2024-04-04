package com.example.machine_translaton_service.service;

import com.example.machine_translaton_service.model.ContentDomain;
import com.example.machine_translaton_service.repository.ContentDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentDomainServiceImpl implements ContentDomainService {

    private final ContentDomainRepository contentDomainRepository;

    @Autowired
    public ContentDomainServiceImpl(ContentDomainRepository contentDomainRepository) {
        this.contentDomainRepository = contentDomainRepository;
    }

    @Override
    public List<ContentDomain> getAllDomains() {
        return contentDomainRepository.findAll();
    }
}
