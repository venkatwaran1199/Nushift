package com.example.nushiftproject.model.utils

import androidx.lifecycle.MutableLiveData
import com.example.nushiftproject.model.data.CityDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Retrofit_services {

    @GET("gistfile1.json")
    suspend fun getcitydetails() : Response<List<CityDataItem>>

    companion object{
        val baseUrl = "https://gist.githubusercontent.com/dastagirkhan/00a6f6e32425e0944241/raw/33ca4e2b19695b2b93f490848314268ed5519894/"

        private var RetrofitService: Retrofit_services? = null

        fun getInstance(): Retrofit_services {
            if (RetrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                RetrofitService = retrofit.create(Retrofit_services::class.java)
            }
            return RetrofitService!!
        }
    }
}