package com.sleepy.sleeplab.ui.quality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.databinding.ActivitySleepQualityBinding
import com.sleepy.sleeplab.ui.quality.result.SleepQualityResultActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SleepQualityActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySleepQualityBinding
    val apiService = RetrofitClient.apiService
    val userPreference = UserPreference.getInstance(dataStore)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepQualityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {

        binding.checkButton.setOnClickListener{



            val duration = binding.etDuration.text.toString()
            val work = binding.etWork.text.toString()
            val sleepDuration = binding.etSleepDuration.text.toString()

            val height = binding.etHeight.text.toString()
            val weight = binding.etWeight.text.toString()
            val bmi = calculateBMI(height,weight)
            val categorizedBMI = categorizeBMI(bmi)



            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val userId = userPreference.getSession().first().id
                    apiService.form(userId,work,sleepDuration.toDouble(),duration.toInt(),categorizedBMI)

                } catch (e: Exception) {
                    Log.e("Error", "Error occurred: ${e.message}", e)
                }
            }
            startActivity(Intent(this, SleepQualityResultActivity::class.java))

        }




    }

    private fun calculateBMI(height: String,weight: String) : Double {
        val heightCm = height.toDouble() / 100.0
        val weightKg = weight.toDouble()

        return weightKg / (heightCm * heightCm)
    }
    private fun categorizeBMI(bmi: Double): Int {
        return when {
            bmi < 19.5 -> 0
            bmi in 18.5..24.9 -> 1
            else -> 2
        }
    }


}