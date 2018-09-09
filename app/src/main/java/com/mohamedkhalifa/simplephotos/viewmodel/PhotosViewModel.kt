package com.mohamedkhalifa.simplephotos.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.learn.archwithkotlin.repository.PhotosRepository
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.util.Constants

class PhotosViewModel : ViewModel() {
    lateinit var photos: MutableLiveData<List<PhotoUIModel>>
    lateinit var error: MutableLiveData<String>
    var photosRepo: PhotosRepository = PhotosRepository

    fun initObservers() {
        photos = MutableLiveData()
        error = MutableLiveData()
    }
    fun getPhotosList(loadFromCache:Boolean) {
        photosRepo.getPhotos(photos, error, Constants.DataSource.FLICKR,loadFromCache)
    }
}
