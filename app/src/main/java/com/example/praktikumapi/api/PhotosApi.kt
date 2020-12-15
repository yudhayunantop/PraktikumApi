package com.example.praktikumapi.api

import com.example.praktikumapi.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

//get data kedalam interface
interface PhotosApi {
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}