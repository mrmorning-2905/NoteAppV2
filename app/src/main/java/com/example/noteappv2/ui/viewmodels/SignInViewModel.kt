package com.example.noteappv2.ui.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.utils.ResultState.Success
import kotlinx.coroutines.launch

class SignInViewModel(
    application: Application,
    private val userRepo: IUserRepo
) : AndroidViewModel(application) {

    fun executeLogin(userName: String, password: String) {
        viewModelScope.launch {
            userRepo.login(userName, password).let { result ->
                val message: String = if (result is Success) {
                    "Login success, try to open all notes screen"
                } else {
                    "Login failed, this account doesn't exist, register new account"
                }
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}