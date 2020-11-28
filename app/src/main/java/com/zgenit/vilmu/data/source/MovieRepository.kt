package com.zgenit.vilmu.data.source

import com.zgenit.vilmu.data.source.remote.response.MovieResponse
import com.zgenit.vilmu.data.source.remote.response.TVShowResponse
import com.zgenit.vilmu.utils.JsonHelper

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieRepository private constructor(private val jsonHelper: JsonHelper) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(jsonHelper: JsonHelper): MovieRepository =
                instance ?: synchronized(this) {
                    instance ?: MovieRepository(jsonHelper)
                }
    }

    override fun getMovies(): List<MovieResponse> {
        val parseFile = jsonHelper.parsingFileToString("movies.json")
        return jsonHelper.loadMovies(parseFile.toString())
    }

    override fun getMovieById(movieId: Int): MovieResponse {
        return MovieResponse()
    }

    override fun getTVShows(): List<TVShowResponse> {
        val parseFile = jsonHelper.parsingFileToString("tv_shows.json")
        return jsonHelper.loadTVShows(parseFile.toString())
    }

    override fun getTVShowById(tvShowId: Int): TVShowResponse {
        return TVShowResponse()
    }
}