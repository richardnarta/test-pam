package com.example.animepaging.api

import com.example.animepaging.models.ResponseAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("X-MAL-CLIENT-ID: a194edc733fff7b6085829f0ca5cb8a5")
    @GET("season/{year}/{season}")
    suspend fun getAnime(
        @Path("year") year:String, @Path("season") season: String, @Query("offset") offset: Int, @Query("sort") sort:String
    ): Response<ResponseAPI>
}