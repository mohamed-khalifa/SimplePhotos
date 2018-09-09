package com.mohamedkhalifa.simplephotos.model

import com.google.gson.annotations.SerializedName

data class FlickrApiPhotos(
        @field:SerializedName("perpage")
        val perPage: Int? = null,

        @field:SerializedName("total")
        val total: Int? = null,

        @field:SerializedName("pages")
        val pages: Int? = null,

        @field:SerializedName("photo")
        val flickrApiPhotosList: List<FlickrApiPhotoItem?>? = null,

        @field:SerializedName("page")
        val page: Int? = null
)