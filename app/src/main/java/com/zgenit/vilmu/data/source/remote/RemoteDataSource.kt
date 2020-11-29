package com.zgenit.vilmu.data.source.remote

import android.os.Handler
import android.os.Looper
import com.zgenit.vilmu.data.source.remote.response.MovieResponse
import com.zgenit.vilmu.data.source.remote.response.TVShowResponse
import com.zgenit.vilmu.utils.DataDummy
import com.zgenit.vilmu.utils.JsonHelper

//
// Created by Mfdsix on 29/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getMovies(callback: LoadMoviesCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            callback.onMoviesReceived(jsonHelper.loadMovies(DataDummy.getMovies()))
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieById(movieId: Int, callback: LoadMovieByIdCallback){
        val movies = jsonHelper.loadMovies(DataDummy.getMovies())

        Handler(Looper.getMainLooper()).postDelayed({
            movies.forEach {
                if(movieId == it.id){
                    callback.onMovieByIdReceived(it)
                }
            }
            callback.onMovieByIdReceived(null)
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVShows(callback: LoadTVShowsCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            callback.onTVShowsReceived(jsonHelper.loadTVShows(DataDummy.getTVShows()))
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVShowById(tvShowId: Int, callback: LoadTVShowByIdCallback){
        val tvShows = jsonHelper.loadTVShows(DataDummy.getTVShows())
        Handler(Looper.getMainLooper()).postDelayed({
            tvShows.forEach {
                if(tvShowId == it.id){
                    callback.onTVShowByIdReceived(it)
                }
            }
            callback.onTVShowByIdReceived(null)
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadMovieByIdCallback {
        fun onMovieByIdReceived(movieResponse: MovieResponse?)
    }

    interface LoadTVShowsCallback {
        fun onTVShowsReceived(tvShowResponses: List<TVShowResponse>)
    }

    interface LoadTVShowByIdCallback {
        fun onTVShowByIdReceived(tvShowResponse: TVShowResponse?)
    }

}