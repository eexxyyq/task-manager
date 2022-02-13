package ru.eexxyyq.taskmanager.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import ru.eexxyyq.taskmanager.config.MapStructConfig
import ru.eexxyyq.taskmanager.dto.TaskDto
import ru.eexxyyq.taskmanager.model.Task

@Mapper(config = MapStructConfig::class)
interface TaskMapper {

    @Mapping(source = "user.id", target = "userId")
    fun toDto(source: Task): TaskDto
    fun toDto(source: List<Task>): List<TaskDto>

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toEntity(source: TaskDto): Task
    fun toEntity(source: List<TaskDto>): List<Task>
}