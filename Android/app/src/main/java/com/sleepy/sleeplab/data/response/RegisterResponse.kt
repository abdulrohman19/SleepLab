package com.sleepy.sleeplab.data.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("success")
	val success: Int
)

data class Data(

	@field:SerializedName("fieldCount")
	val fieldCount: Int,

	@field:SerializedName("serverStatus")
	val serverStatus: Int,

	@field:SerializedName("changedRows")
	val changedRows: Int,

	@field:SerializedName("affectedRows")
	val affectedRows: Int,

	@field:SerializedName("warningStatus")
	val warningStatus: Int,

	@field:SerializedName("insertId")
	val insertId: Int,

	@field:SerializedName("info")
	val info: String
)
