package com.wo.geranciamentotarefas.dto;

import com.wo.geranciamentotarefas.enums.Status;
import jakarta.validation.constraints.NotBlank;

public record TaskDto(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        Status status) {
}
