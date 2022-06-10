package com.example.interviewprepbatch

import com.example.interviewprepbatch.classes.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

//    https://community-open-weather-map.p.rapidapi.com

    @GET("weather")
    @Headers("X-RapidAPI-Key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077",
    "X-RapidAPI-Host: community-open-weather-map.p.rapidapi.com")
    fun getWeatherData(@Query("q")name : String,@Query("units")unit : String="metric") : Call<Weather>  // abstract

}