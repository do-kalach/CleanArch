package com.agening.domain.usecase

import com.agening.domain.models.SaveUserNameParam
import com.agening.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param:SaveUserNameParam): Boolean{
        val result:Boolean = userRepository.saveName(saveParam = param)
        return result
    }

}