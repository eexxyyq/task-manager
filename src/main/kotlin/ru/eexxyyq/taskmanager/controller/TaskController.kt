package ru.eexxyyq.taskmanager.controller

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*
import ru.eexxyyq.taskmanager.dto.TaskDto
import ru.eexxyyq.taskmanager.service.TaskService

@RestController
@RequestMapping(path = ["task"])
@Api(tags = ["Task Controller"])
class TaskController(private val taskService: TaskService) {

    @PostMapping
    fun create(@RequestBody user: TaskDto) = taskService.create(user)

    @GetMapping("/{userId}")
    fun getById(@PathVariable userId: Long) = taskService.getAllByUserId(userId)
}