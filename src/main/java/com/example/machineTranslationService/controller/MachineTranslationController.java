package com.example.machineTranslationService.controller;

import com.example.machineTranslationService.model.ContentDomain;
import com.example.machineTranslationService.model.TranslateContent;
import com.example.machineTranslationService.model.dto.LangCodeDto;
import com.example.machineTranslationService.model.dto.TranslateContentDto;
import com.example.machineTranslationService.service.ContentDomainService;
import com.example.machineTranslationService.service.LangCodeService;
import com.example.machineTranslationService.service.TranslateContentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MachineTranslationController {

    private final LangCodeService langCodeService;
    private final ContentDomainService contentDomainService;
    private final TranslateContentService translateContentService;
    public MachineTranslationController(LangCodeService langCodeService, ContentDomainService contentDomainService, TranslateContentService translateContentService) {
        this.langCodeService = langCodeService;
        this.contentDomainService = contentDomainService;
        this.translateContentService = translateContentService;
    }

    @GetMapping(path = "/languages")
    public ResponseEntity<List<LangCodeDto>> allLanguages() {
        return ResponseEntity.ok(langCodeService.allLangCodes());
    }

    @GetMapping(path = "/domain")
    public ResponseEntity<List<ContentDomain>> allDomains() {
        return ResponseEntity.ok(contentDomainService.getAllDomains());
    }

    @PostMapping(path = "/translate")
    public ResponseEntity<TranslateContent> translateContent(@Valid @RequestBody TranslateContentDto translateContentDto) {
        return ResponseEntity.ok(translateContentService.translateContent(translateContentDto));
    }
}

