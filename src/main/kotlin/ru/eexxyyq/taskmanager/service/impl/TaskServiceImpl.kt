package ru.eexxyyq.taskmanager.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.eexxyyq.taskmanager.dto.TaskDto
import ru.eexxyyq.taskmanager.mapper.TaskMapper
import ru.eexxyyq.taskmanager.repository.TaskRepository
import ru.eexxyyq.taskmanager.repository.UserRepository
import ru.eexxyyq.taskmanager.service.KafkaProducerService
import ru.eexxyyq.taskmanager.service.TaskService

@Service
class TaskServiceImpl(
    val taskRepository: TaskRepository,
    val taskMapper: TaskMapper,
    val kafkaProducerService: KafkaProducerService,
    val objectMapper: ObjectMapper,
    val userRepository: UserRepository
) : TaskService {
    val logger: Logger = LoggerFactory.getLogger(TaskServiceImpl::class.java)

    override fun create(task: TaskDto): TaskDto {
        val user = userRepository.getById(task.userId)
        val taskToSave = taskMapper.toEntity(task)
        taskToSave.user = user
        val savedTask = taskRepository.save(taskToSave)
        val data = objectMapper.writeValueAsString(savedTask)
        logger.info(data)
        kafkaProducerService.send("tasks", data)
        return taskMapper.toDto(savedTask)
    }

    override fun getAllByUserId(userId: Long): List<TaskDto> {
        return taskMapper.toDto(taskRepository.getAllByUserId(userId))
    }
}