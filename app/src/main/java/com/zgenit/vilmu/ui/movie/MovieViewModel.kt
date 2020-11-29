package com.zgenit.vilmu.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.remote.response.MovieResponse

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieViewModel(private val movieRepository: MovieRepository): ViewModel(){
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getMovies()

    fun getMovieById(movieId: Int) : LiveData<MovieEntity?> = movieRepository.getMovieById(movieId)
}