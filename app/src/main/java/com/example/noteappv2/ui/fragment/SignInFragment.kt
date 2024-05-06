package com.example.noteappv2.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteappv2.R
import com.example.noteappv2.databinding.SiginFragmentLayoutBinding
import com.example.noteappv2.ui.NoteViewModelFactory
import com.example.noteappv2.ui.viewmodels.SignInViewModel
import com.example.noteappv2.utils.log.Logger

class SignInFragment : BaseFragment() {

    override val logTag: String = SignInFragment::class.java.simpleName

    private var _binding: SiginFragmentLayoutBinding? = null

    private val signInViewModel by viewModels<SignInViewModel> { NoteViewModelFactory }

    private val binding get() = _binding!!

    override fun getLayoutId(): Int {
        return R.layout.sigin_fragment_layout
    }

    override fun initView(rootView: View) {
        setupToolbar("", false)
        _binding = SiginFragmentLayoutBinding.bind(rootView)

        binding.signUpBtn.setOnClickListener { setupNavigation() }
        binding.buttonLogin.setOnClickListener { handleSignInClickListener() }
    }

    private fun handleSignInClickListener() {
        Logger.d(logTag, "handleSignInClickListener()")
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
}