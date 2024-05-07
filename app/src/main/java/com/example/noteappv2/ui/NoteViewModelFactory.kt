package com.example.noteappv2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.noteappv2.NoteApplication
import com.example.noteappv2.ui.viewmodels.NotesListViewModel
import com.example.noteappv2.ui.viewmodels.SignInViewModel
import com.example.noteappv2.ui.viewmodels.SignUpViewModel

@Suppress("UNCHECKED_CAST")
val NoteViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        with(modelClass) {
            val application = checkNotNull(extras[APPLICATION_KEY]) as NoteApplication
            val userRepo = application.userRepository
            val noteRepo = application.noteRepository
            when {
                isAssignableFrom(SignInViewModel::class.java) -> SignInViewModel(application, userRepo)
                isAssignableFrom(SignUpViewModel::class.java) -> SignUpViewModel(application, userRepo)
                isAssignableFrom(NotesListViewModel::class.java) -> NotesListViewModel(application, noteRepo)
                else -> IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}