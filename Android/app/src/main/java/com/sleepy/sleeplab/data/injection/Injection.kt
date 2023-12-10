package com.sleepy.sleeplab.data.injection

import android.content.Context
import com.sleepy.sleeplab.data.pref.UserPreference
import com.sleepy.sleeplab.data.pref.dataStore
import com.sleepy.sleeplab.data.repository.UserRepository

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}