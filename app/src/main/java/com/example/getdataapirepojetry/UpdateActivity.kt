package com.example.getdataapirepojetry

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.getdataapirepojetry.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val id =  intent.getStringExtra("userId")
       val userId =  intent.getStringExtra("id")
       val body =  intent.getStringExtra("body")
       val title =  intent.getStringExtra("title")

        binding.id.setText(id)
        binding.userId.setText(userId)
        binding.body.setText(body)
        binding.title.setText(title)
    }
}