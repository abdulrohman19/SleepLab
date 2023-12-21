package com.sleepy.sleeplab.ui.quality.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.sleepy.sleeplab.R
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.data.response.ResultQualityResponse
import com.sleepy.sleeplab.databinding.ActivitySleepQualityResultBinding
import com.sleepy.sleeplab.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SleepQualityResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySleepQualityResultBinding
    val apiService = RetrofitClient.apiService
    val userPreference = UserPreference.getInstance(dataStore)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepQualityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }


    private fun setupAction() {

        lifecycleScope.launch(Dispatchers.Main) {
            try {
                val userId = userPreference.getSession().first().id
                val resultResponse: ResultQualityResponse = apiService.result(userId)

                val result: String = resultResponse.data.results
                val message: String = resultResponse.data.message
                val sugesst: String = resultResponse.data.suggestions

                when(result) {
                    "None" -> binding.imgQualityResult.setImageResource(R.drawable.wellsleep)
                    "Insomnia" -> binding.imgQualityResult.setImageResource(R.drawable.insomnia)
                    "Sleep Apnea" -> binding.imgQualityResult.setImageResource(R.drawable.apnea)
                }


                binding.titleQualityResult.text = result
                binding.messageQualityResult.text = message
                binding.suggestQualityResult.text = sugesst


            } catch (e: Exception) {
                Log.e("Error", "Error occurred: ${e.message}", e)
            }
        }

        binding.closeBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}