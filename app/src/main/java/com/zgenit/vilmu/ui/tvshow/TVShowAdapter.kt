package com.zgenit.vilmu.ui.tvshow

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
import com.zgenit.vilmu.data.tvshow.TVShowEntity
import java.util.*

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private var listDatas = ArrayList<TVShowEntity>()

    fun setDatas(tvShows: List<TVShowEntity>?) {
        if (tvShows == null) return
        this.listDatas.clear()
        this.listDatas.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv_show, parent, false)
        return TVShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val data = listDatas[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listDatas.size

    class TVShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TVShowEntity) {
            val tvItemTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
            val tvItemCategory = itemView.findViewById<TextView>(R.id.tv_item_category)
            val tvItemDuration = itemView.findViewById<TextView>(R.id.tv_item_duration)
            val imgPoster = itemView.findViewById<ImageView>(R.id.img_poster)

            tvItemTitle.text = tvShow.title
            tvItemCategory.text = tvShow.category
            tvItemDuration.text = tvShow.duration

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, TVShowDetailActivity::class.java)
                intent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW, tvShow.id)
                itemView.context.startActivity(intent)
            }
            Glide.with(itemView.context)
                .load(tvShow.img)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imgPoster)
        }
    }
}