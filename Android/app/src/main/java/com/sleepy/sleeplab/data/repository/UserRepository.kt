package com.sleepy.sleeplab.data.repository

import com.sleepy.sleeplab.data.api.ApiService
import com.sleepy.sleeplab.data.pref.UserModel
import com.sleepy.sleeplab.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(private val userPreference: UserPreference){

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference)
            }.also { instance = it }
    }

}