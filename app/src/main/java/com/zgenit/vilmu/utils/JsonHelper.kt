package com.zgenit.vilmu.utils

import android.content.Context
import com.zgenit.vilmu.data.source.remote.response.MovieResponse
import com.zgenit.vilmu.data.source.remote.response.TVShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.ArrayList

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class JsonHelper(private val context: Context) {

    fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(json: String): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(json)
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val posterPath =  Constant.IMG_BASE_URL + movie.getString("poster_path")
                val voteAverage = movie.getDouble("vote_average")
                val releaseDate = movie.getString("release_date")
                val language = movie.getString("original_language")

                val movieResponse = MovieResponse(
                        id,
                        title,
                        overview,
                        posterPath,
                        voteAverage,
                        releaseDate,
                        language,
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTVShows(json: String): List<TVShowResponse> {
        val list = ArrayList<TVShowResponse>()
        try {
            val responseObject = JSONObject(json)
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getInt("id")
                val title = tvShow.getString("name")
                val overview = tvShow.getString("overview")
                val posterPath =  Constant.IMG_BASE_URL + tvShow.getString("poster_path")
                val voteAverage = tvShow.getDouble("vote_average")
                val firstAirDate = tvShow.getString("first_air_date")
                val language = tvShow.getString("original_language")

                val tvShowResponse = TVShowResponse(
                        id,
                        title,
                        overview,
                        posterPath,
                        voteAverage,
                        firstAirDate,
                        language,
                )
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

}

