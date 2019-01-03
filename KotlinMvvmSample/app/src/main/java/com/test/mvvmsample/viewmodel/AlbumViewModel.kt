package com.test.mvvmsample.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.mvvmsample.api.UserService
import com.test.mvvmsample.model.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumViewModel : ViewModel() {

    var mAlumList: MutableLiveData<List<Album>> = MutableLiveData()

    fun fetchAlbums() : MutableLiveData<List<Album>> {
        UserService().create().fetchAlbums().enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                mAlumList.value = response.body()!!
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                mAlumList.value = null
            }
        })
        return mAlumList
    }
}