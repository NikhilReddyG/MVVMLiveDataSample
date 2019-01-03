package com.test.app.api

import com.test.mvvmsample.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface UserRequest {

    @GET("albums")
    fun fetchAlbums(): Call<List<Album>>
}