package com.sleepy.sleeplab.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AlertDialog
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.databinding.ActivityRegisterBinding
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

    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener{

            val fullName = binding.fullnameEditText.toString()
            val age = binding.ageEditText.toString()
            val gender = binding.optGender.toString()
            val password = binding.passwordEditText.toString()
            val email = binding.emailEditText.toString()

            GlobalScope.launch(Dispatchers.IO){
                try {
                    apiService.regis(fullName,age.toInt(),gender,email,password)
                } catch (e: Exception){
                    Log.e("Error",e.message.toString())
                }
            }

            AlertDialog.Builder(this).apply {
                setTitle("Yeay!")
                setMessage("Halo $fullName , Silahkan Lanjut Ke Menu Login!")
                setPositiveButton("Lanjut") { _, _ ->
                    finish()
                }
                create()
                show()
            }

        }
    }

}