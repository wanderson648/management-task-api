package com.wo.geranciamentotarefas.mapper;

import com.wo.geranciamentotarefas.dto.TaskDto;
import com.wo.geranciamentotarefas.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    Task toModel(TaskDto taskDto);
}
