package com.example.nushiftproject.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nushiftproject.model.data.CityDataItem
import com.example.nushiftproject.model.repository.Retrofitrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Retrofitviewmodel(private val retrofitrepository: Retrofitrepository):ViewModel() {

val reporesult : LiveData<List<CityDataItem>>
    get() = retrofitrepository.citylist

    fun getcitydata(){
        viewModelScope.launch(Dispatchers.IO){
            retrofitrepository.getcitydata()
        }
    }


    val totaladdeddata = MutableLiveData<List<CityDataItem>>()
    val currdata = ArrayList<CityDataItem>()
    fun addIssuePost(citydata: CityDataItem) {
        currdata.add(citydata)
        totaladdeddata.value = totaladdeddata.value?.plus(currdata)
    }


}