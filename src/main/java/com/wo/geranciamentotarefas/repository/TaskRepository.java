package com.wo.geranciamentotarefas.repository;

import com.wo.geranciamentotarefas.model.Task;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
    @Query("{status:{$regex: '^?0', $options:'i'}}")
    Flux<Task> findAllByStatus(@Param("status") String status);
}
