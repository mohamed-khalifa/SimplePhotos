package com.mohamedkhalifa.simplephotos.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoUIModel(val imageUrl: String?,val thumbnailUrl:String?) : Parcelable