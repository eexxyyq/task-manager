package ru.eexxyyq.taskmanager.dto

import ru.eexxyyq.taskmanager.model.TaskStatus

data class TaskDto(
    var userId: Long,
    var description: String,
    var status: TaskStatus = TaskStatus.NEW
)
