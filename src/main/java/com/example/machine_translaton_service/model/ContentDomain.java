package com.example.machine_translaton_service.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContentDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String domain;
}
