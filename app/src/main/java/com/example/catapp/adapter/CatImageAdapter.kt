package com.example.catapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catapp.Model.CatImage
import com.example.catapp.R
import com.squareup.picasso.Picasso

class CatImageAdapter(private val catImages: List<CatImage>) : RecyclerView.Adapter<CatImageAdapter.CatImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_image, parent, false)
        return CatImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatImageViewHolder, position: Int) {
        val catImage = catImages[position]
        Picasso.get().load(catImage.url).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    class CatImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: android.widget.ImageView = itemView.findViewById(R.id.imageViewCat)
    }
}
