package com.example.interviewprepbatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.interviewprepbatch.classes.Weather
import com.example.interviewprepbatch.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val api = WeatherHelper.getApi()

        binding.btnFind.setOnClickListener {

            val location : String = binding.edtLocation.text.toString()

            val call : Call<Weather> =  api.getWeatherData(location)

            call.enqueue(object : Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    val weather = response.body()

//                    Log.i("response",weather.toString())

                    binding.obj = weather

                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {

                }

            })

        }

    }
}