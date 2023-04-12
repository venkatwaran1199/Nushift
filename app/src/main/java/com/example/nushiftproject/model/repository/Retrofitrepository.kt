package com.example.nushiftproject.model.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.model.utils.Retrofit_services

class Retrofitrepository(private val retrofitServices: Retrofit_services) {

 var citylist = MutableList<CityDataItem>()
  get() =

    suspend fun getcitydata(){
        val result = retrofitServices.getcitydetails()
        if(result.body()!=null){
            Log.d(TAG, "getcitydata: "+result.body())
            citylist = result.body()!!
        }
    }
}