package com.zgenit.vilmu.ui.movie

import androidx.lifecycle.ViewModel
import com.zgenit.vilmu.data.movie.MovieListEntity
import com.zgenit.vilmu.data.movie.MovieSingleEntity
import com.zgenit.vilmu.utils.DataDummy

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieViewModel: ViewModel(){
    fun getMovies(): MovieListEntity {
        val datas = DataDummy.getMovies()

        return if(datas.isNotEmpty()){
            MovieListEntity(
                    true,
                    "success",
                    datas
            )
        }else{
            MovieListEntity(
                    false,
                    "no data available",
            )
        }
    }

    fun getMovieById(movieId: Int) : MovieSingleEntity {
        val data = DataDummy.getMovieById(movieId = movieId)

        return if(data != null){
            MovieSingleEntity(
                    true,
                    "success",
                    data
            )
        }else{
            MovieSingleEntity(
                    false,
                    "data not found",
            )
        }
    }
}