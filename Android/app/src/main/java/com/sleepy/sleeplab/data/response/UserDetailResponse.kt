package com.sleepy.sleeplab.data.response

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(

	@field:SerializedName("data")
	val data: DetailData,

	@field:SerializedName("success")
	val success: Int
)

data class DetailData(

	@field:SerializedName("full_name")
	val fullName: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("age")
	val age: Int,

	@field:SerializedName("email")
	val email: String
)
