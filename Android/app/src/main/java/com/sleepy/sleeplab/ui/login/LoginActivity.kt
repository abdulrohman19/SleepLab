package com.sleepy.sleeplab.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.ViewModelFactory
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserModel
import com.sleepy.sleeplab.databinding.ActivityLoginBinding
import com.sleepy.sleeplab.ui.main.MainActivity
import com.sleepy.sleeplab.ui.register.RegisterActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityLoginBinding
    val apiService = RetrofitClient.apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()

        binding.passwordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validatePassword()
            }
        }
        binding.emailEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateEmail()
            }
        }

    }

    private fun validatePassword() {
        val password = binding.passwordEditText.text.toString()
        if (password.isNotEmpty()){
            if (password.length < 8) {
                binding.passwordEditTextLayout.error = "Character must have at least 8 character"
            }
            else {
                binding.passwordEditTextLayout.error = null
            }
        }else{
            binding.passwordEditTextLayout.error = null
        }

    }

    private fun validateEmail() {
        val email = binding.emailEditText.text.toString().trim()

        if (email.isNotEmpty()) {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            if (!email.matches(emailPattern.toRegex())) {
                binding.emailEditTextLayout.error = "Invalid email address"
            } else {
                binding.emailEditTextLayout.error = null
            }
        } else {
            binding.emailEditTextLayout.error = null
        }
    }

    private fun setupAction() {
        binding.signinButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = apiService.login(email,password)

                    if (response.loginResult != null) {
                        val name = response.loginResult.name
                        val userId = response.loginResult.id
                        val token = response.loginResult.token

                        withContext(Dispatchers.Main){
                            viewModel.saveSession(UserModel(email,token,true))
                            val intent = Intent(this@LoginActivity,MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }

                    }
                    else {
                        if (response.message != null) {
                            Log.d("LoginActivity", "Pesan respons: ${response.message}")
                        }
                    }

                } catch (e: Exception){
                    Log.e("Error", "Error occurred: ${e.message}", e)
                }
            }
        }

        binding.signupTv.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }
    }


}
