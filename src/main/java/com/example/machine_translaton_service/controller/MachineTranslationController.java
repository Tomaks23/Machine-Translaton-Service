package com.example.machine_translaton_service.controller;

import com.example.machine_translaton_service.model.ContentDomain;
import com.example.machine_translaton_service.model.TranslateContent;
import com.example.machine_translaton_service.model.dto.LangCodeDto;
import com.example.machine_translaton_service.model.dto.TranslateContentDto;
import com.example.machine_translaton_service.service.ContentDomainService;
import com.example.machine_translaton_service.service.LangCodeService;
import com.example.machine_translaton_service.service.TranslateContentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MachineTranslationController {

    private final LangCodeService langCodeService;
    private final ContentDomainService contentDomainService;
    private final TranslateContentServiceImpl translateContentService;

    public MachineTranslationController(LangCodeService langCodeService, ContentDomainService contentDomainService, TranslateContentServiceImpl translateContentService) {
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

    @PostMapping(path = "/validated-translate")
    public ResponseEntity<TranslateContent> validateTranslate(@Valid @RequestBody TranslateContentDto translateContentDto){
        return ResponseEntity.ok(translateContentService.validateTranslate(translateContentDto));
    }


}

