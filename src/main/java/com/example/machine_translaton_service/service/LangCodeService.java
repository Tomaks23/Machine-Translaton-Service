package com.example.machine_translaton_service.service;

import com.example.machine_translaton_service.model.dto.LangCodeDto;

import java.util.List;

public interface LangCodeService {
    List<LangCodeDto> allLangCodes();
}
