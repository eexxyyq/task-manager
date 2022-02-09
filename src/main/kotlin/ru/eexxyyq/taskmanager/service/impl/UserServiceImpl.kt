package ru.eexxyyq.taskmanager.service.impl

import ru.eexxyyq.taskmanager.exception.BusinessException
import ru.eexxyyq.taskmanager.exception.ErrorType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.eexxyyq.taskmanager.dto.UserDto
import ru.eexxyyq.taskmanager.mapper.UserMapper
import ru.eexxyyq.taskmanager.model.User
import ru.eexxyyq.taskmanager.repository.UserRepository
import ru.eexxyyq.taskmanager.service.UserService

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserService {

    @Transactional
    override fun save(user: User): UserDto = userMapper.toDto(userRepository.save(user))

    @Transactional
    override fun update(user: User, id: Long): UserDto {
        var resultUser: UserDto? = null
        userRepository.findById(id)
            .ifPresent { u ->
                run {
                    user.id = u.id
                    resultUser = userMapper.toDto(userRepository.save(user))
                }
            }
        if (resultUser == null) {
            throw BusinessException(ErrorType.USER_NOT_FOUND)
        }
        return resultUser!!
    }

    @Transactional
    override fun delete(id: Long) {
        val user = userRepository.findById(id)
            .orElseThrow { BusinessException(ErrorType.USER_NOT_FOUND) }
        userRepository.delete(user)
    }

    @Transactional
    override fun getById(id: Long): UserDto {
        val user =  userRepository.findById(id)
            .orElseThrow { BusinessException(ErrorType.USER_NOT_FOUND) }
        return userMapper.toDto(user)
    }

    @Transactional
    override fun getAll(): List<UserDto> = userMapper.toDto(userRepository.findAll())
}