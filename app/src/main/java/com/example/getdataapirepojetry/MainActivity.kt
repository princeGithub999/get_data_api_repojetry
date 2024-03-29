package com.example.getdataapirepojetry

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdataapirepojetry.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userList = ArrayList<UserDataItem>()

    @SuppressLint("MissingInflatedId", "CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ApiSever.createRetrofit().getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                for (myData in it) {
                    userList.add(myData)
                }
                val adapter = UserAdpater(this, userList)
                binding.recycleView.layoutManager = LinearLayoutManager(this)
                binding.recycleView.adapter = adapter
            }


        val postData = UserPostData(1, "prince", "prince Yadav")
        ApiSever.createRetrofit().addPost(postData)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                Toast.makeText(this, "${it.body}", Toast.LENGTH_SHORT).show()
            }


    }

}


