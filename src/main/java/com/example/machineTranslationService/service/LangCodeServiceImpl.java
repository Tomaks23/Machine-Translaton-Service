package com.example.machineTranslationService.service;

import com.example.machineTranslationService.model.LangCode;
import com.example.machineTranslationService.model.dto.LangCodeDto;
import com.example.machineTranslationService.repository.LangCodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangCodeServiceImpl implements LangCodeService {

    @Autowired
    private LangCodeRepository langCodeRepository;

    public List<LangCodeDto> allLangCodes() {
        List<LangCode> langCodes = langCodeRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return langCodes.stream()
                .map(langCode -> modelMapper.map(langCode, LangCodeDto.class))
                .toList();
    }
}


