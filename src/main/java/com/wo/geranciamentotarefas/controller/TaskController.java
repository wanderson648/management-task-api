package com.wo.geranciamentotarefas.controller;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/task")
public class TaskController {


    @PostMapping
    public ResponseEntity<Mono<Task>> createTask(@RequestBody @Valid TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping
    public ResponseEntity<Flux<Task>> listAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Mono<Void>> updateTask(
            @PathVariable("taskId") String taskId, @RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Mono<Void>> deleteTask(@PathVariable("taskId") String taskId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
