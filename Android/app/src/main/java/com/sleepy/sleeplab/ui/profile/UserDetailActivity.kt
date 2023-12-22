package com.sleepy.sleeplab.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.data.response.UpdateDetailResponse
import com.sleepy.sleeplab.data.response.UserDetailResponse
import com.sleepy.sleeplab.databinding.ActivityMainBinding
import com.sleepy.sleeplab.databinding.ActivityUserDetailBinding
import com.sleepy.sleeplab.ui.login.LoginActivity
import com.sleepy.sleeplab.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    val apiService = RetrofitClient.apiService
    val userPreference = UserPreference.getInstance(dataStore)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAction()
    }

    private fun setupAction(){

        lifecycleScope.launch(Dispatchers.Main) {
            try {

                val userId = userPreference.getSession().first().id
                val token = userPreference.getSession().first().token
                val tokens = "Bearer $token"
                val userDetail: UserDetailResponse = apiService.userDetail(userId,tokens)

                val fullName: String = userDetail.data.fullName
                val age: Int = userDetail.data.age
                val gender: String = userDetail.data.gender
                val email: String = userDetail.data.email

                Log.d("Debug","FullName: $fullName")


                binding.etFullname.setText(fullName)
                binding.etAge.setText(age.toString())
                binding.etEmail.setText(email)


            }catch (e: Exception){
                Log.e("Error", "Error occurred: ${e.message}", e)
            }
        }

        binding.submitBtn.setOnClickListener{
            val fullName = binding.etFullname.text.toString()
            val age = binding.etAge.text.toString()
            val gender = binding.genderchoose.text.toString()
            val password = binding.etPassword.text.toString()
            val email = binding.etEmail.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val userId = userPreference.getSession().first().id
                    val token = userPreference.getSession().first().token
                    val tokens = "Bearer $token"

                    apiService.updateDetail(tokens,fullName,age.toInt(),gender,email,password,userId)
                } catch (e: Exception) {
                    Log.e("Error", "Error occurred: ${e.message}", e)
                }
            }
            startActivity(Intent(this, MainActivity::class.java))
        }

        val gender = listOf("Male","Female")
        val genderchoose : AutoCompleteTextView = findViewById(R.id.genderchoose)
        val genderadapter = ArrayAdapter(this,R.layout.list_item,gender)

        genderchoose.setAdapter(genderadapter)
        genderchoose.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view,i, l ->

            val genderSelected = adapterView.getItemAtPosition(i)
        }

    }
}