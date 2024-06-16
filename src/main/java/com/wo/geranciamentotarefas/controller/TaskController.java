package com.wo.geranciamentotarefas.controller;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.model.Task;
import com.wo.geranciamentotarefas.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Mono<Task>> createTask(@RequestBody @Valid TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskDto));
    }

    @GetMapping
    public ResponseEntity<Flux<Task>> listAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Mono<Void>> updateTask(
            @PathVariable("taskId") String taskId, @RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskService.updateTask(taskId, taskDto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Mono<Void>> deleteTask(@PathVariable("taskId") String taskId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskService.delete(taskId));
    }

    @GetMapping("/status")
    public ResponseEntity<Flux<Task>> listAllByStatus(
            @RequestParam(value = "status", required = false, defaultValue = "") String status) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllByStatus(status));
    }

    @PatchMapping("/status/{taskId}")
    public ResponseEntity<Mono<Task>> changeTaskStatus(@PathVariable("taskId") String taskId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskService.changeTaskStatus(taskId));
    }
}
