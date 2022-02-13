package ru.eexxyyq.taskmanager.service

import ru.eexxyyq.taskmanager.dto.TaskDto

interface TaskService {

    fun create(task: TaskDto): TaskDto
    fun getAllByUserId(userId: Long): List<TaskDto>
}