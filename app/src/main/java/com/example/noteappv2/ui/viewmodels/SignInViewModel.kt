package com.example.noteappv2.ui.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.utils.ResultState.Success
import com.example.noteappv2.utils.log.Logger
import kotlinx.coroutines.launch

class SignInViewModel(
    application: Application,
    private val userRepo: IUserRepo
) : AndroidViewModel(application) {
    private val logTag = SignInViewModel::class.java.simpleName

    fun executeLogin(userName: String, password: String, block: (Long) -> Unit) {
        viewModelScope.launch {
            userRepo.login(userName, password).let { result ->
                val message: String = if (result is Success) {
                    val userId = result.data.uId
                    Logger.d(logTag, "login with User: ${result.data}")
                    userId?.let { block(userId) }
                    "Login success, try to open all notes screen"
                } else {
                    "Login failed, this account doesn't exist, register new account"
                }
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}