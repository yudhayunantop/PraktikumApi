package com.example.praktikumapi.api

import com.example.praktikumapi.model.Photo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {

    // memasukkan link kedalam variable
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi

    // inisialisasi api
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    //get data
    fun getPhotos(): Single<List<Photo>> {
        return api.getPhotos()
    }
}