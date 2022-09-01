package com.hdd.photogallery.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "740e1c88e0611ee93c8b25676541ed43"

class PhotoInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl: HttpUrl = originalRequest.url.newBuilder().addQueryParameter("api_key", API_KEY)
            .addQueryParameter("format", "json").addQueryParameter("nojasoncallback", "1")
            .addQueryParameter("extras", "url_s").addQueryParameter("safesearch", "1").build()

        val newRequest: Request = originalRequest.newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)
    }

}