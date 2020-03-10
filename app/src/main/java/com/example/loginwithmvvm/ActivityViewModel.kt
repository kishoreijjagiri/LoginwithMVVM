package com.example.loginwithmvvm

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginwithmvvm.Network.ApiService
import com.example.loginwithmvvm.Network.NetworkService
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityViewModel(val applicationContext: Context) : ViewModel(){

lateinit var successData:MutableLiveData<String>

    init {
        successData=MutableLiveData()
    }

    fun login(year:String){
       val service=NetworkService().getRetrofitInstance()?.create(ApiService::class.java)

        service?.login(year)?.enqueue(object :Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
               Toast.makeText(applicationContext,"Failure",Toast.LENGTH_LONG).show()
                successData.postValue("Failure")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
               successData.postValue("Success")
            }
        })
    }

}