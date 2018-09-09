package com.mohamedkhalifa.simplephotos.data

import android.arch.lifecycle.MutableLiveData
import com.mohamedkhalifa.simplephotos.model.PhotoContainerUIModel
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel

abstract class PhotoDataSource(protected val photos: MutableLiveData<List<PhotoUIModel>>, protected val error: MutableLiveData<String>) {
    abstract fun getPhotos(photoContainerUIModel: PhotoContainerUIModel)
    protected abstract fun mapToPhotoUIModel(photoUrl: String?,thumbnailUrl:String?): PhotoUIModel
}