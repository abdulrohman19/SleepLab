package com.sleepy.sleeplab.data.response

import com.google.gson.annotations.SerializedName

data class ResultQualityResponse(

	@field:SerializedName("data")
	val data: Datas,

	@field:SerializedName("success")
	val success: Int
)

data class Datas(

	@field:SerializedName("suggestions")
	val suggestions: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("results")
	val results: String
)
