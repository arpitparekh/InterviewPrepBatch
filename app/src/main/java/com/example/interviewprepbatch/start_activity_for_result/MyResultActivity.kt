package com.example.interviewprepbatch.start_activity_for_result

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.interviewprepbatch.databinding.ActivityMyResultBinding

class MyResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

        val player = MediaPlayer.create(this, Uri.parse(songUrl))

//        ActivityResultLauncher<Intent> launcher

        val launch : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                val uri = it.data?.data

                binding.ivGallery.setImageURI(uri)
            })
        val launcher2 : ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.ivFileExplorer.setImageURI(it)
            })

        val launcher3 : ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.RequestPermission(),
            ActivityResultCallback {
                if(it){
                    Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show()
                }
            })

        binding.ivGallery.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("*/*")
//            startActivityForResult(intent,101)
            launch.launch(intent)

        }

        binding.ivFileExplorer.setOnClickListener {

            launcher2.launch("image/*")

        }

        binding.btnPermission.setOnClickListener {

            launcher3.launch(Manifest.permission.CAMERA)

        }

    }
}