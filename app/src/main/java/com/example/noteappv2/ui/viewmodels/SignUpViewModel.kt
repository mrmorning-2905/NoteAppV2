package com.example.noteappv2.ui.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.utils.ResultState
import kotlinx.coroutines.launch

class SignUpViewModel(
    application: Application,
    private val userRepo: IUserRepo
) : AndroidViewModel(application) {

//    init {
//        viewModelScope.launch {
//            val userEntity = userRepo.getUserById(uId = 1L).let { resultState ->
//
//            }
//        }
//    }

    fun executeRegisterAccount(user: UserEntity) {
        viewModelScope.launch {
            userRepo.registerAccount(user).let {
                    result ->
                val message: String = if (result is ResultState.Success) {
                    "Register new account success, return to start sign in"
                } else {
                    "Register failed, please try again"
                }
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}