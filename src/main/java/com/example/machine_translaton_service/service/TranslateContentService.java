package com.example.machine_translaton_service.service;

import com.example.machine_translaton_service.model.TranslateContent;
import com.example.machine_translaton_service.model.dto.TranslateContentDto;

public interface TranslateContentService {
    TranslateContent translateContent(TranslateContentDto translateContentDto);
    TranslateContent validateTranslate(TranslateContentDto translateContentDto);
}
