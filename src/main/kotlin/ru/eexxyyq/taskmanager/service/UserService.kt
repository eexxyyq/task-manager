package ru.eexxyyq.taskmanager.service

import ru.eexxyyq.taskmanager.dto.UserDto
import ru.eexxyyq.taskmanager.model.User


interface UserService {
    fun save(user: User): UserDto
    fun update(user: User, id: Long): UserDto
    fun delete(id: Long)
    fun getById(id: Long): UserDto
    fun getAll(): List<UserDto>
}