package com.sleepy.sleeplab.data.response

import com.google.gson.annotations.SerializedName

data class InputQualityResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("success")
	val success: Int
)


