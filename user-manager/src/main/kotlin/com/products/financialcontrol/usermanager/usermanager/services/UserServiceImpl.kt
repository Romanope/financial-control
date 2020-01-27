package com.products.financialcontrol.usermanager.usermanager.services

import com.products.financialcontrol.usermanager.usermanager.model.User
import com.products.financialcontrol.usermanager.usermanager.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun findUserByEmail(email: String): User {
        return userRepository.findUserByEmail(email)
    }

    override fun save(user: User): User {
        user.dateRegister = LocalDateTime.now()
        return userRepository.save(user)
    }

    override fun update(user: User): User {
        return userRepository.save(user)
    }

    override fun deleteById(id: Long) {
        userRepository.deleteById(id)
    }

    override fun findById(id: Long): User {
        return userRepository.findById(id).orElseThrow()
    }
}