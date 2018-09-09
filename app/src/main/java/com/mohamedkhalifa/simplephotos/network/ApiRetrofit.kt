package com.learn.archwithkotlin.network

import com.mohamedkhalifa.simplephotos.model.FlickrPhotosApiResponse
import com.mohamedkhalifa.simplephotos.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofit {
    @GET(Constants.FLICKR_URL)
    fun getPhotos(@Query("gallery_id")  galleryId:String="72157662070816797",
                  @Query("per_page") numberOfItemsPerPage:Int=10,
                  @Query("page") page:Int,
                  @Query("method") method:String ="flickr.galleries.getPhotos",
                  @Query("api_key")  apiKey:String="cb0ffde768d0c6281cc10832d4250696",
                  @Query("extras") extras:String="url_sq,url_t,url_m",
                  @Query("format") format:String="json",
                  @Query("nojsoncallback")  noJsonCallBack:String="1"): Call<FlickrPhotosApiResponse>
}

//https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=827e2a77740cde8f23382e337d6e47a3&gallery_id=72157662070816797&per_page=10&extras=url_o&page=1&format=json&nojsoncallback=1&auth_token=72157700823874554-f9d8a8a2d4dcd904&api_sig=2c635cad9dc77a9288cc196b09d46af8