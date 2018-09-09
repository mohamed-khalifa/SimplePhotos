package com.learn.archwithkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.mohamedkhalifa.simplephotos.data.FlickrDataSource
import com.mohamedkhalifa.simplephotos.data.PhotoDataSource
import com.mohamedkhalifa.simplephotos.model.PhotoContainerUIModel
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.util.Constants


object PhotosRepository {
    var photoContainerUIModel: PhotoContainerUIModel = PhotoContainerUIModel

    fun getPhotos(photos: MutableLiveData<List<PhotoUIModel>>, error: MutableLiveData<String>, dataSource: Constants.DataSource, loadFromCache: Boolean) {
        val photoDataSource: PhotoDataSource
        if (dataSource == Constants.DataSource.FLICKR) {
            if (loadFromCache && photos.value != null) {
                photos.value = photos.value
            } else {
                photoDataSource = FlickrDataSource(photos, error)
                photoDataSource.getPhotos(photoContainerUIModel)
            }
        }

    }

}

