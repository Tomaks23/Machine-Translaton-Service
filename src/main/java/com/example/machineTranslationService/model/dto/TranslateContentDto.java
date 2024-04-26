package com.example.machineTranslationService.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslateContentDto {
    @NotBlank(message = "Source language is required")
    private String sourceLanguage;
    @NotBlank(message = "Target language is required")
    private String targetLanguage;
    @NotBlank(message = "Domain is required")
    private String domain;
    @NotBlank(message = "Content is required")
    private String content;
}
