package com.wo.geranciamentotarefas.service;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
    Mono<Task> create(TaskDto taskDto);
    Flux<Task> findAll();
    Mono<Void> updateTask(String taskId, TaskDto taskDto);
    Mono<Void> delete(String taskId);
    Flux<Task> findAllByStatus(String status);
}
