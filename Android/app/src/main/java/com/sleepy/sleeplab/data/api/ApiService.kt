package com.sleepy.sleeplab.data.api

import com.sleepy.sleeplab.data.response.InputQualityResponse
import com.sleepy.sleeplab.data.response.LoginResponse
import com.sleepy.sleeplab.data.response.RegisterResponse
import com.sleepy.sleeplab.data.response.ResultQualityResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse


    @FormUrlEncoded
    @POST("form/{id}")
    suspend fun form(
        @Path("id") id: String,
        @Field("job") job: String,
        @Field("sleep_duration") sleep_duration: Double,
        @Field("activity_level") activity_level: Int,
        @Field("bmi") bmi: Int,
    ): InputQualityResponse


    @GET("result/{id}")
    suspend fun result(
        @Path("id") id: String
    ): ResultQualityResponse

}