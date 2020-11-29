package com.zgenit.vilmu.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowViewModel(private val movieRepository: MovieRepository): ViewModel(){

    fun getTVShows(): LiveData<List<TVShowEntity>> = movieRepository.getTVShows()

    fun getTVShowVById(tvShowId: Int): LiveData<TVShowEntity?> = movieRepository.getTVShowById(tvShowId)
}