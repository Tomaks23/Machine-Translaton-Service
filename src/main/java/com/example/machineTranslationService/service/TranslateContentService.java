package com.example.machineTranslationService.service;

import com.example.machineTranslationService.model.TranslateContent;
import com.example.machineTranslationService.model.dto.TranslateContentDto;

public interface TranslateContentService {
    TranslateContent translateContent(TranslateContentDto translateContentDto);
    TranslateContent validateTranslate(TranslateContentDto translateContentDto);
}
