package com.example.noteappv2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteappv2.databinding.SiginFragmentLayoutBinding
import com.example.noteappv2.ui.viewmodels.SignInViewModel

class SignInFragment : Fragment() {

    private var _binding: SiginFragmentLayoutBinding? = null

    private val signInViewModel by viewModels<SignInViewModel> { NoteViewModelFactory }

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SiginFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // handle action here
        binding.signUpBtn.setOnClickListener {
            setupNavigation()
        }

        binding.buttonLogin.setOnClickListener { handleSignInClickListener() }
    }

    private fun handleSignInClickListener() {
        val userName = binding.inputUserName.text?.toString()
        val password = binding.inputPassword.text?.toString()
        if (userName == null || password == null) {
            Toast.makeText(context, "Please fill user name and password to sign in", Toast.LENGTH_SHORT).show()
            return
        }
        signInViewModel.executeLogin(userName, password)
    }

    private fun setupNavigation() {
        val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        //close some resource
    }
}