package com.sleepy.sleeplab.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AlertDialog
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.databinding.ActivityRegisterBinding
import com.sleepy.sleeplab.ui.login.LoginActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    val apiService = RetrofitClient.apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
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
        binding.signupButton.setOnClickListener{

            val fullName = binding.fullnameEditText.text.toString()
            val age = binding.ageEditText.text.toString()
            val gender = binding.genderEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val email = binding.emailEditText.text.toString()


            GlobalScope.launch(Dispatchers.IO){
                try {
                    apiService.regis(fullName,age.toInt(),gender,email,password)


                } catch (e: Exception){
                    Log.e("Error", "Error occurred: ${e.message}", e)
                }
            }
            startActivity(Intent(this,LoginActivity::class.java))

            AlertDialog.Builder(this).apply {
                setTitle("Selamat Datang!")
                setMessage("Halo $fullName, Silahkan Lanjut Ke Menu Sign In!")
                setPositiveButton("Kembali") { _, _ ->
                    finish()
                }
                create()
                show()
            }

        }

        binding.signinTv.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

}