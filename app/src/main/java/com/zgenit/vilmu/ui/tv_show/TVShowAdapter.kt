package com.zgenit.vilmu.ui.tv_show

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zgenit.vilmu.R
import com.zgenit.vilmu.data.TVShowEntity
import kotlinx.android.synthetic.main.items_movie.view.*
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
            with(itemView) {
                tv_item_title.text = tvShow.title
                tv_item_category.text = tvShow.category
                tv_item_duration.text = tvShow.duration
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
                    .into(img_poster)
            }
        }
    }
}