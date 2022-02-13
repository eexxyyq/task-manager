package ru.eexxyyq.taskmanager.controller

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.*
import ru.eexxyyq.taskmanager.model.User
import ru.eexxyyq.taskmanager.service.UserService

@RestController
@RequestMapping(path = ["user"])
@Api(tags = ["User Controller"])
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll() = userService.getAll()

    @PostMapping
    fun create(@RequestBody user: User)= userService.save(user)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getById(id)
}