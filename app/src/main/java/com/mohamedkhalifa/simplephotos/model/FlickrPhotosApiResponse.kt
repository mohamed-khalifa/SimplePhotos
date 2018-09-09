package com.mohamedkhalifa.simplephotos.model

import com.google.gson.annotations.SerializedName

data class FlickrPhotosApiResponse(

	@field:SerializedName("stat")
	val stat: String? = null,

	@field:SerializedName("photos")
	val flickrApiPhotos: FlickrApiPhotos? = null
)