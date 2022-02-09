package ru.eexxyyq.taskmanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.eexxyyq.taskmanager.model.User

interface UserRepository : JpaRepository<User, Long> {
}