package com.example.catapp.API

import com.example.catapp.Model.CatImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("images/search")
    fun getCatImages(@Query("limit") limit: Int): Call<List<CatImage>>
}
