package com.hdd.photogallery.api

import com.hdd.photogallery.FlickrResponse
import retrofit2.http.GET

interface FlickrApi {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=740e1c88e0611ee93c8b25676541ed43" +
                "&format=json&nojsoncallback=1" +
                "&extras=url_s"
    )

    suspend fun fetchPhotos(): FlickrResponse
}