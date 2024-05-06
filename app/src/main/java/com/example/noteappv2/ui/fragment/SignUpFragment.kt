package com.example.noteappv2.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteappv2.R
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.databinding.SignUpFragmentBinding
import com.example.noteappv2.ui.NoteViewModelFactory
import com.example.noteappv2.ui.viewmodels.SignUpViewModel

class SignUpFragment : BaseFragment() {

    override val logTag: String = SignUpFragment::class.java.simpleName

    private var _binding: SignUpFragmentBinding? = null

    private val signUpViewModel by viewModels<SignUpViewModel> { NoteViewModelFactory }

    private val binding get() = _binding!!

    override fun getLayoutId(): Int {
        return R.layout.sign_up_fragment
    }

    override fun initView(rootView: View) {
        setupToolbar("", true)
        _binding = SignUpFragmentBinding.bind(rootView)
        binding.signInBtn.setOnClickListener { setupNavigation() }
        //binding.backNavigationBtn.setOnClickListener { setupNavigation() }
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}