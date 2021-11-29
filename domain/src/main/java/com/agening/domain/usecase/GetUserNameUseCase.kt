package com.agening.domain.usecase

import com.agening.domain.models.UserName
import com.agening.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute():UserName{
        return userRepository.getName()
    }

}