package com.zgenit.vilmu.data.source

import com.zgenit.vilmu.data.source.remote.response.MovieResponse
import com.zgenit.vilmu.data.source.remote.response.TVShowResponse

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

interface MovieDataSource {

    fun getMovies(): List<MovieResponse>

    fun getMovieById(movieId: Int): MovieResponse

    fun getTVShows(): List<TVShowResponse>

    fun getTVShowById(tvShowId: Int): TVShowResponse
}