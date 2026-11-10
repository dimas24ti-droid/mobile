package com.example.saturnus_dimasbudi.pert6.home.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.pert6.data.model.PhotoModel

class PhotoAdapter(private val items: List<PhotoModel>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = items[position]
        holder.tvAuthor.text = item.author
        Glide.with(holder.itemView.context)
            .load(item.download_url)
            .placeholder(R.drawable.red)
            .error(R.drawable.red)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int = items.size
}
