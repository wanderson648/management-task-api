package com.wo.geranciamentotarefas.model;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document("tasks")
public class Task {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private Status status = Status.NOT_COMPLETED;

    private LocalDateTime dtCreation;

    public Task(TaskDto taskDto) {
        this.name = taskDto.name();
        this.description = taskDto.description();
        this.dtCreation = LocalDateTime.now();
    }
}
