package ru.eexxyyq.taskmanager.mapper

import org.mapstruct.Mapper
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.eexxyyq.taskmanager.config.MapStructConfig
import ru.eexxyyq.taskmanager.dto.UserDto
import ru.eexxyyq.taskmanager.model.User

@Mapper(config = MapStructConfig::class)
interface UserMapper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun toDto(source: User): UserDto
    fun toDto(source: List<User>): List<UserDto>

}