package ru.eexxyyq.taskmanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.eexxyyq.taskmanager.model.Task

interface TaskRepository : JpaRepository<Task, Long> {
    fun getAllByUserId(userId: Long): List<Task>
}