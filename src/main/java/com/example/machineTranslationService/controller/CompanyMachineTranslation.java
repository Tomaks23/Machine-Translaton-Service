package com.example.machineTranslationService.controller;

import com.example.machineTranslationService.model.TranslateContent;
import com.example.machineTranslationService.model.dto.TranslateContentDto;
import com.example.machineTranslationService.service.TranslateContentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cmt")
public class CompanyMachineTranslation {



    TranslateContentService translateContentService;
    @Autowired
    public CompanyMachineTranslation(TranslateContentService translateContentService) {
        this.translateContentService = translateContentService;
    }
    @PostMapping(path = "/validated-translate")
    public ResponseEntity<TranslateContent> validateTranslate(@Valid @RequestBody TranslateContentDto translateContentDto) {
        return ResponseEntity.ok(translateContentService.validateTranslate(translateContentDto));
    }
}
