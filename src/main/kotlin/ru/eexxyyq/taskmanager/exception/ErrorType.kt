package ru.eexxyyq.taskmanager.exception

enum class ErrorType(val description: String) {
    USER_NOT_FOUND("User with id %s not exists")
}