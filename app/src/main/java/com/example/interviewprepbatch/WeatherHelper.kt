package com.example.interviewprepbatch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherHelper {

    companion object{

        fun getApi() : WeatherApi{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://community-open-weather-map.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api : WeatherApi =  retrofit.create(WeatherApi::class.java)  // :: type convertor

            return api

            // kotlin  // is interoperable with java

        }

    }

}