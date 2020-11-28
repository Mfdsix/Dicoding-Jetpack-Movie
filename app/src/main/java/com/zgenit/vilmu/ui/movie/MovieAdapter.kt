package com.zgenit.vilmu.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.source.remote.response.MovieResponse
import java.util.*

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.CourseViewHolder>() {
    private var listDatas = ArrayList<MovieResponse>()

    fun setDatas(courses: List<MovieResponse>) {
        this.listDatas.clear()
        this.listDatas.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val data = listDatas[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listDatas.size

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieResponse) {
            val tvItemTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
            val tvItemCategory = itemView.findViewById<TextView>(R.id.tv_item_category)
            val tvItemDuration = itemView.findViewById<TextView>(R.id.tv_item_duration)
            val imgPoster = itemView.findViewById<ImageView>(R.id.img_poster)

            tvItemTitle.text = movie.title
            tvItemCategory.text = movie.language
            tvItemDuration.text = movie.releaseDate

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie.id)
                itemView.context.startActivity(intent)
            }
            Glide.with(itemView.context)
                .load(movie.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imgPoster)
        }
    }
}