package com.example.praktikumapi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.praktikumapi.R
import com.example.praktikumapi.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*


class PhotoListAdapter(var photos: ArrayList<Photo>) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    //handle list saat muncul data baru
    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    //inisialisasi item list RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //render data kedalam recyclerView
        fun bind(photos: Photo) {
            itemView.idGambar.text = photos.id.toString()
            itemView.tvTitle.text = photos.title
            itemView.url.text = photos.url
            itemView.setOnClickListener { view -> Toast.makeText(itemView.context,"Hello",Toast.LENGTH_LONG).show()
                }
//                Glide.with(itemView.context)
//                    .load(photos.thumbnail)
//                    .error(Glide.with(itemView.img_gambar)
//                        .load(R.drawable.ic_launcher_background))
//                    .apply(RequestOptions.centerCropTransform())
//                    .into(itemView.img_gambar)
                Picasso.get().load(photos.thumbnail).into(itemView.img_gambar)
        }
    }
}