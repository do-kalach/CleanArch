package com.agening.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agening.data.repository.UserRepositoryImpl
import com.agening.data.storage.sharedrefs.SharedPrefUserStorage
import com.agening.domain.models.SaveUserNameParam
import com.agening.domain.models.UserName
import com.agening.domain.usecase.GetUserNameUseCase
import com.agening.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase:GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
):ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive:LiveData<String> = resultLiveMutable

    init {
        Log.e("TAG", "VM Created")
    }

    fun save(text:String){
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Saved data $result"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value =  "${userName.firstName} ${userName.lastName}"
    }

    override fun onCleared() {
        Log.e("TAG", "VM Cleared")
        super.onCleared()
    }

}