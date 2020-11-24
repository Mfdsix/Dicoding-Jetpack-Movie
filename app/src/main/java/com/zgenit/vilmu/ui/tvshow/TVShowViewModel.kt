package com.zgenit.vilmu.ui.tvshow

import androidx.lifecycle.ViewModel
import com.zgenit.vilmu.data.tvshow.TVShowListEntity
import com.zgenit.vilmu.data.tvshow.TVShowSingleEntity
import com.zgenit.vilmu.utils.DataDummy

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowViewModel: ViewModel(){

    fun getTVShows(): TVShowListEntity {
        val datas = DataDummy.getTVShows()

        return if(datas.isNotEmpty()){
            TVShowListEntity(
                    true,
                    "success",
                    datas
            )
        }else{
            TVShowListEntity(
                    false,
                    "no data found",
            )
        }
    }

    fun getTVShowVById(tvShowId: Int): TVShowSingleEntity {
        val data = DataDummy.getTVShowById(tvShowId = tvShowId)

        return if(data != null){
            TVShowSingleEntity(
                    true,
                    "success",
                    data
            )
        }else{
            TVShowSingleEntity(
                    false,
                    "no data found"
            )
        }
    }
}