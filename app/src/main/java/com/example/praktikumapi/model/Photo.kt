package com.example.praktikumapi.model

import com.google.gson.annotations.SerializedName

//inisialisasi objek dan data yg diambil dari api
data class Photo(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnailUrl")
    val thumbnail: String?,
    @SerializedName("url")
    val url: String?
)