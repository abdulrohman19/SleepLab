package com.sleepy.sleeplab.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.ViewModelFactory
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.data.response.UserDetailResponse
import com.sleepy.sleeplab.databinding.ActivityProfileBinding
import com.sleepy.sleeplab.ui.main.MainActivity
import com.sleepy.sleeplab.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    val apiService = RetrofitClient.apiService
    val userPreference = UserPreference.getInstance(dataStore)

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()

        binding.btnLogout.setOnClickListener{
            viewModel.logout()
            finish()
        }

        binding.card.setOnClickListener{
            startActivity(Intent(this,UserDetailActivity::class.java))
        }
    }

    private fun setupAction(){

        lifecycleScope.launch(Dispatchers.Main) {
            try {

                val userId = userPreference.getSession().first().id
                val token = userPreference.getSession().first().token
                val tokens = "Bearer $token"
                val userDetail: UserDetailResponse = apiService.userDetail(userId,tokens)

                val fullName: String = userDetail.data.fullName
                val email: String = userDetail.data.email


                binding.detailNama.text = fullName
                binding.detailEmail.text = email


            }catch (e: Exception){
                Log.e("Error", "Error occurred: ${e.message}", e)
            }
        }


    }
}