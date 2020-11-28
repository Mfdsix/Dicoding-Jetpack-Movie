package com.zgenit.vilmu.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.di.Injection
import com.zgenit.vilmu.ui.movie.MovieViewModel
import com.zgenit.vilmu.ui.tvshow.TVShowViewModel

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}