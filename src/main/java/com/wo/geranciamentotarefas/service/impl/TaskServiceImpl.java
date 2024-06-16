package com.wo.geranciamentotarefas.service.impl;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.enums.Status;
import com.wo.geranciamentotarefas.model.Task;
import com.wo.geranciamentotarefas.repository.TaskRepository;
import com.wo.geranciamentotarefas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Mono<Task> create(TaskDto taskDto) {
        return taskRepository.save(new Task(taskDto));
    }

    @Override
    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Mono<Void> updateTask(String taskId, TaskDto taskDto) {
        return taskRepository.findById(taskId)
                .flatMap(task -> {
                    task.setId(taskId);
                    task.setName(taskDto.name());
                    task.setDescription(taskDto.description());
                    task.setStatus(Status.NOT_COMPLETED);
                    task.setDtCreation(LocalDateTime.now());

                    return taskRepository.save(task);
                }).switchIfEmpty(Mono.error(() -> new RuntimeException("Task Not found"))).then();
    }

    @Override
    public Mono<Void> delete(String taskId) {
        Mono<Task> taskMono = taskRepository.findById(taskId)
                .switchIfEmpty(Mono.error(() -> new RuntimeException("Task Not found")));

        return taskMono.flatMap(taskRepository::delete).then();
    }

    @Override
    public Flux<Task> findAllByStatus(String status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public Mono<Task> changeTaskStatus(String taskId) {
        Mono<Task> taskMono = taskRepository.findById(taskId)
                .switchIfEmpty(Mono.error(() -> new RuntimeException("Task Not found")));

        return taskMono.flatMap(this::changeStatus);
    }

    private Mono<Task> changeStatus(Task task) {
        if (task.getStatus().equals(Status.COMPLETED)) {
            task.setStatus(Status.NOT_COMPLETED);
        } else {
            task.setStatus(Status.COMPLETED);
        }
        return taskRepository.save(task);
    }
}
