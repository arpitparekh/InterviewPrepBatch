package com.example.interviewprepbatch.passData_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interviewprepbatch.R
import com.example.interviewprepbatch.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {

    lateinit var binding  : ActivityHostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = supportFragmentManager

        // FragmentManager manager = getSupportFragmentManager()

        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fcvHost,OneFragment())

        transaction.commit()

    }
}