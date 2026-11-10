package com.example.saturnus_dimasbudi.pert6.data.api

import com.example.saturnus_dimasbudi.pert6.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
