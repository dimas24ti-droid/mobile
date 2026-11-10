package com.example.saturnus_dimasbudi.pert6.data.api

import com.example.saturnus_dimasbudi.pert6.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
