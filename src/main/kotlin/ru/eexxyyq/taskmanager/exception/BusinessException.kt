package ru.eexxyyq.taskmanager.exception

class BusinessException(errorType: ErrorType, message: String? = null) : RuntimeException(message?:errorType.description) {
}