package com.sleepy.sleeplab.data.injection

import android.content.Context
import com.sleepy.sleeplab.data.api.RetrofitClient
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.data.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = RetrofitClient.getApiService(user.token)
        return UserRepository.getInstance(pref)
    }
}