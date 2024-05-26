package com.example.machineTranslationService.service;

import com.example.machineTranslationService.model.LangCode;
import com.example.machineTranslationService.model.dto.LangCodeDto;
import com.example.machineTranslationService.repository.LangCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class LangCodeServiceImpl implements LangCodeService {

  @Autowired
  private LangCodeRepository langCodeRepository;

  public List<LangCodeDto> allLangCodes() {
    List<LangCode> langCodes = langCodeRepository.findAll();
    return langCodes.stream()
        .map(langCode -> new LangCodeDto(langCode.getId(), langCode.getCode()))
        .collect(Collectors.toList());
  }
}


