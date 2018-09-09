package com.mohamedkhalifa.simplephotos.model

import com.google.gson.annotations.SerializedName

data class FlickrApiPhotoItem(

	@field:SerializedName("server")
	val server: String? = null,

	@field:SerializedName("url_t")
	val urlT: String? = null,

	@field:SerializedName("height_s")
	val heightS: String? = null,

	@field:SerializedName("height_t")
	val heightT: String? = null,

	@field:SerializedName("is_primary")
	val isPrimary: Int? = null,

	@field:SerializedName("url_s")
	val urlS: String? = null,

	@field:SerializedName("isfriend")
	val isfriend: Int? = null,

	@field:SerializedName("secret")
	val secret: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("height_m")
	val heightM: String? = null,

	@field:SerializedName("url_sq")
	val urlSq: String? = null,


	@field:SerializedName("width_t")
	val widthT: String? = null,

	@field:SerializedName("width_s")
	val widthS: String? = null,

	@field:SerializedName("has_comment")
	val hasComment: Int? = null,

	@field:SerializedName("ispublic")
	val ispublic: Int? = null,

	@field:SerializedName("farm")
	val farm: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("width_m")
	val widthM: String? = null,

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("width_sq")
	val widthSq: Int? = null,

	@field:SerializedName("isfamily")
	val isfamily: Int? = null,

	@field:SerializedName("height_sq")
	val heightSq: Int? = null,

	@field:SerializedName("url_m")
	val urlM: String? = null
)