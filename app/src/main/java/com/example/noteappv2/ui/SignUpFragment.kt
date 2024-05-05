package com.example.noteappv2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.databinding.SignUpFragmentBinding
import com.example.noteappv2.ui.viewmodels.SignUpViewModel

class SignUpFragment : Fragment() {

    private var _binding: SignUpFragmentBinding? = null

    private val signUpViewModel by viewModels<SignUpViewModel> { NoteViewModelFactory }

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signInBtn.setOnClickListener { setupNavigation() }
        binding.backNavigationBtn.setOnClickListener { setupNavigation() }
        binding.buttonCreateAccount.setOnClickListener { handleCreateAccountClickListener() }
    }

    private fun setupNavigation() {
        val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
        findNavController().navigate(action)
    }

    private fun handleCreateAccountClickListener() {
        val userName = binding.inputUserName.text?.toString()
        val password = binding.inputPassword.text?.toString()
        val confirmPassword = binding.inputConfirmPassword.text?.toString()
        if (userName == null || password == null || confirmPassword == null) {
            Toast.makeText(context, "Please fill user name and password to sign in", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(context, "Password not match, Please check again.", Toast.LENGTH_SHORT).show()
            return
        }

        val newUser = UserEntity(uId = null, userName = userName, password = password)
        signUpViewModel.executeRegisterAccount(newUser)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}