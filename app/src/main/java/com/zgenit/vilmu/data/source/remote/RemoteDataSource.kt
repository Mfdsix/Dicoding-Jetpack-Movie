package com.zgenit.vilmu.data.source.remote

import android.os.Handler
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
import com.zgenit.vilmu.utils.DataDummy
import com.zgenit.vilmu.utils.EspressoIdlingResource

//
// Created by Mfdsix on 29/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class RemoteDataSource{

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(callback: LoadMoviesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMoviesReceived(DataDummy.getMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieById(movieId: Int, callback: LoadMovieByIdCallback){
        EspressoIdlingResource.increment()
        val movies = DataDummy.getMovies()

        handler.postDelayed({
            movies.forEach {
                if(movieId == it.id){
                    callback.onMovieByIdReceived(it)
                    EspressoIdlingResource.decrement()
                    return@postDelayed
                }
            }
            callback.onMovieByIdReceived(null)
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVShows(callback: LoadTVShowsCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onTVShowsReceived(DataDummy.getTVShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVShowById(tvShowId: Int, callback: LoadTVShowByIdCallback){
        EspressoIdlingResource.increment()
        val tvShows = DataDummy.getTVShows()

        handler.postDelayed({
            tvShows.forEach {
                if(tvShowId == it.id){
                    callback.onTVShowByIdReceived(it)
                    EspressoIdlingResource.decrement()
                    return@postDelayed
                }
            }
            callback.onTVShowByIdReceived(null)
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponses: List<MovieEntity>)
    }

    interface LoadMovieByIdCallback {
        fun onMovieByIdReceived(movieResponse: MovieEntity?)
    }

    interface LoadTVShowsCallback {
        fun onTVShowsReceived(tvShowResponses: List<TVShowEntity>)
    }

    interface LoadTVShowByIdCallback {
        fun onTVShowByIdReceived(tvShowResponse: TVShowEntity?)
    }

}