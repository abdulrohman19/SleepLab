package com.sleepy.sleeplab.data.pref

data class UserModel (
    val id: String,
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)