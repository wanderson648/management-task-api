package com.wo.geranciamentotarefas.dto;

public record ErrorResponseDto(
        String message,
        int httpStatusCode
) {
}
