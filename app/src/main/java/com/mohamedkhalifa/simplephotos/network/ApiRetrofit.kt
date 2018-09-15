package com.mohamedkhalifa.simplephotos.network

import com.mohamedkhalifa.simplephotos.model.FlickrPhotosApiResponse
import com.mohamedkhalifa.simplephotos.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRetrofit {
    @GET(Constants.FLICKR_URL)
    fun getPhotos(@Query("gallery_id")  galleryId:String="72157662070816797",
                  @Query("per_page") numberOfItemsPerPage:Int=15,
                  @Query("page") page:Int,
                  @Query("method") method:String ="flickr.galleries.getPhotos",
                  @Query("api_key")  apiKey:String="d29895597ed67fab39488e27abef96fa",
                  @Query("extras") extras:String="url_sq,url_t,url_m",
                  @Query("format") format:String="json",
                  @Query("nojsoncallback")  noJsonCallBack:String="1"): Call<FlickrPhotosApiResponse>
}