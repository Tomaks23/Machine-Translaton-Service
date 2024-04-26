package com.example.machineTranslationService.service;

import com.example.machineTranslationService.model.ContentDomain;
import com.example.machineTranslationService.repository.ContentDomainRepository;
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
