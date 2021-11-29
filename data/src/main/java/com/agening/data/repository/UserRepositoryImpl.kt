package com.agening.data.repository

import com.agening.data.storage.models.User
import com.agening.data.storage.UserStorage
import com.agening.domain.models.SaveUserNameParam
import com.agening.domain.models.UserName
import com.agening.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam:SaveUserNameParam):Boolean{

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user:User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)

    }

}