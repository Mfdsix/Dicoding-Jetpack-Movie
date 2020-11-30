package com.zgenit.vilmu.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import java.util.*

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData)
            }
    }

    override fun getMovies(): LiveData<List<MovieEntity>> {

        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMovies(object: RemoteDataSource.LoadMoviesCallback{
            override fun onMoviesReceived(movieResponses: List<MovieEntity>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val course = MovieEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.voteAverage,
                            response.releaseDate,
                            response.language,
                    )

                    movieList.add(course)
                }
                movieResults.postValue(movieList)
            }

        })

        return movieResults
    }

    override fun getMovieById(movieId: Int): LiveData<MovieEntity?> {

        val movieResult = MutableLiveData<MovieEntity?>()
        remoteDataSource.getMovieById(movieId, object : RemoteDataSource.LoadMovieByIdCallback{

            override fun onMovieByIdReceived(movieResponse: MovieEntity?) {
                if(movieResponse != null){
                    movieResult.postValue(MovieEntity(
                            movieResponse.id,
                            movieResponse.title,
                            movieResponse.overview,
                            movieResponse.posterPath,
                            movieResponse.voteAverage,
                            movieResponse.releaseDate,
                            movieResponse.language,
                    ))
                }
            }

        })

        return movieResult
    }

    override fun getTVShows(): LiveData<List<TVShowEntity>> {

        val tvShowResults = MutableLiveData<List<TVShowEntity>>()

        remoteDataSource.getTVShows(object : RemoteDataSource.LoadTVShowsCallback{

            override fun onTVShowsReceived(tvShowResponses: List<TVShowEntity>) {
                val tvShowList = ArrayList<TVShowEntity>()
                for (response in tvShowResponses) {
                    val course = TVShowEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.voteAverage,
                            response.firstAirDate,
                            response.language,
                    )

                    tvShowList.add(course)
                }

                tvShowResults.postValue(tvShowList)
            }

        })

        return tvShowResults
    }

    override fun getTVShowById(tvShowId: Int): LiveData<TVShowEntity?> {

        val tvShowResult = MutableLiveData<TVShowEntity?>()

        remoteDataSource.getTVShowById(tvShowId, object : RemoteDataSource.LoadTVShowByIdCallback{

            override fun onTVShowByIdReceived(tvShowResponse: TVShowEntity?) {
                if(tvShowResponse != null){
                    tvShowResult.postValue(TVShowEntity(
                            tvShowResponse.id,
                            tvShowResponse.title,
                            tvShowResponse.overview,
                            tvShowResponse.posterPath,
                            tvShowResponse.voteAverage,
                            tvShowResponse.firstAirDate,
                            tvShowResponse.language,
                    ))
                }
            }

        })

        return tvShowResult
    }
}