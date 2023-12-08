package com.sleepy.sleeplab.data.api

import com.sleepy.sleeplab.data.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
@FormUrlEncoded
@POST("regis")
suspend fun regis(
    @Field("fullName") fullName : String,
    @Field("age") age : Int,
    @Field("gender") gender : String,
    @Field("email") email : String,
    @Field("password") password : String,
) : RegisterResponse


}