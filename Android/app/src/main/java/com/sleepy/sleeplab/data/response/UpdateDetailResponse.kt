package com.sleepy.sleeplab.data.response

import com.google.gson.annotations.SerializedName

data class UpdateDetailResponse(

	@field:SerializedName("success")
	val success: Int,

	@field:SerializedName("message")
	val message: String
)
