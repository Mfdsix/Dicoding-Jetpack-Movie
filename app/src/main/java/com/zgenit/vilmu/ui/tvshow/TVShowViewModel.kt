package com.zgenit.vilmu.ui.tvshow

import androidx.lifecycle.ViewModel
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.remote.response.TVShowResponse

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowViewModel(private val movieRepository: MovieRepository): ViewModel(){

    fun getTVShows(): List<TVShowResponse> = movieRepository.getTVShows()

    fun getTVShowVById(tvShowId: Int): TVShowResponse = movieRepository.getTVShowById(tvShowId)
}