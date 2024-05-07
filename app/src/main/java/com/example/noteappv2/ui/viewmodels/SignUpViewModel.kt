package com.example.noteappv2.ui.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.utils.ResultState
import com.example.noteappv2.utils.log.Logger
import kotlinx.coroutines.launch

class SignUpViewModel(
    application: Application,
    private val userRepo: IUserRepo
) : AndroidViewModel(application) {

    private val logTag = SignUpViewModel::class.java.simpleName

    fun executeRegisterAccount(user: UserEntity) {
        viewModelScope.launch {
            userRepo.registerAccount(user).let {
                    result ->
                val message: String = if (result is ResultState.Success) {
                    Logger.d(logTag, "register success with new User: ${result.data}")
                    "Register new account success, return to start sign in"
                } else {
                    "Register failed, please try again"
                }
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}