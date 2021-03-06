package com.mohamedkhalifa.simplephotos.data

import android.arch.lifecycle.MutableLiveData
import com.learn.archwithkotlin.network.ApiConnection
import com.mohamedkhalifa.simplephotos.model.FlickrPhotosApiResponse
import com.mohamedkhalifa.simplephotos.model.PhotoContainerUIModel
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.network.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FlickrDataSource(photos: MutableLiveData<List<PhotoUIModel>>, error: MutableLiveData<String>) : PhotoDataSource(photos, error) {
    override fun getPhotos(photoContainerUIModel: PhotoContainerUIModel) {
        val numberOfPages = photoContainerUIModel.numberOfPages
        val currentPage = photoContainerUIModel.currentPage
        if (numberOfPages == null || currentPage <= numberOfPages) {
            executeRequest(ApiConnection.getRetrofitCall().create(ApiRetrofit::class.java).getPhotos(page = currentPage), photos, error, photoContainerUIModel)
        } else {
            photos.value = photoContainerUIModel.photos
        }

    }

    private fun executeRequest(questionsCall: Call<FlickrPhotosApiResponse>, photos: MutableLiveData<List<PhotoUIModel>>, error: MutableLiveData<String>, photoContainerUIModel: PhotoContainerUIModel) {
        questionsCall.enqueue(object : Callback<FlickrPhotosApiResponse> {
            override fun onFailure(call: Call<FlickrPhotosApiResponse>?, t: Throwable?) {
                error.value = "error"
            }

            override fun onResponse(call: Call<FlickrPhotosApiResponse>?, response: Response<FlickrPhotosApiResponse>?) {
                if (response?.body() != null && response.body()?.stat.equals("ok")) {


                    val flickrPhotosResponse = response.body()?.flickrApiPhotos
                    flickrPhotosResponse.let { flickrApiPhotos ->
                        if (flickrApiPhotos?.page != null) {
                            photoContainerUIModel.currentPage = flickrApiPhotos.page + 1
                        }
                        photoContainerUIModel.numberOfPages = flickrApiPhotos?.pages
                        val flickrUIList: List<PhotoUIModel>? = flickrApiPhotos?.flickrApiPhotosList?.map {
                            mapToPhotoUIModel(it?.urlM, it?.urlSq)
                        }

                        if (photoContainerUIModel.photos == null) {
                            photoContainerUIModel.photos = mutableListOf()
                        }

                        if (flickrUIList != null) {
                            photoContainerUIModel.photos?.addAll(flickrUIList)
                            photos.value = photoContainerUIModel.photos
                        }
                    }
                } else {
                    error.value = "error"
                }
            }
        })
    }

    override fun mapToPhotoUIModel(photoUrl: String?, thumbnailUrl: String?): PhotoUIModel {
        return PhotoUIModel(photoUrl, thumbnailUrl)
    }

}