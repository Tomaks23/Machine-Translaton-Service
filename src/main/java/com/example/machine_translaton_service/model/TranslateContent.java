package com.example.machine_translaton_service.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TranslateContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sourceLanguage;
    private String targetLanguage;
    private String domain;
    private String content;
}
