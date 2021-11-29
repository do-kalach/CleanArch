package com.agening.domain.repository

import com.agening.domain.models.SaveUserNameParam
import com.agening.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam):Boolean

    fun getName(): UserName
}