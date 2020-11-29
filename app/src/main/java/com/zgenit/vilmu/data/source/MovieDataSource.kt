package com.zgenit.vilmu.data.source

import androidx.lifecycle.LiveData
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

interface MovieDataSource {

    fun getMovies(): LiveData<List<MovieEntity>>

    fun getMovieById(movieId: Int): LiveData<MovieEntity?>

    fun getTVShows(): LiveData<List<TVShowEntity>>

    fun getTVShowById(tvShowId: Int): LiveData<TVShowEntity?>
}