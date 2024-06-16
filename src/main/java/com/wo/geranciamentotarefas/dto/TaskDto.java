package com.wo.geranciamentotarefas.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskDto(
        @NotBlank
        String name,
        @NotBlank
        String description) {
}
