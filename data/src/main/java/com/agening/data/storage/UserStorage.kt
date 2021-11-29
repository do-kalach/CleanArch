package com.agening.data.storage

import com.agening.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}