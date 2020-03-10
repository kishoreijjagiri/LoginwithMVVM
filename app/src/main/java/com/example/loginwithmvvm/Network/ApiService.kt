package com.example.loginwithmvvm.Network

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("Client/GetMakes/{year}")
    fun login(@Path("year") Year:String):Call<JsonElement>

}