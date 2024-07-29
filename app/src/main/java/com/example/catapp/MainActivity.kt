package com.example.catapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catapp.API.InstanceRetrofit
import com.example.catapp.Model.CatImage
import com.example.catapp.adapter.CatImageAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_cat)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Retrofit API
        val api = InstanceRetrofit.api
        api.getCatImages(10).enqueue(object : Callback<List<CatImage>> {
            override fun onResponse(call: Call<List<CatImage>>, response: Response<List<CatImage>>) {
                if (response.isSuccessful) {
                    val catImages = response.body() ?: emptyList()
                    recyclerView.adapter = CatImageAdapter(catImages)
                }
            }

            override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
