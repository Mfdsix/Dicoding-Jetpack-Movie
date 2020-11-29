package com.zgenit.vilmu.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import com.zgenit.vilmu.ui.movie.MovieViewModel
import com.zgenit.vilmu.ui.tvshow.TVShowViewModel
import com.zgenit.vilmu.utils.JsonHelper
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieRepositoryTest {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var tvShowViewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository
    @Mock
    private lateinit var movieObserver: Observer<List<MovieEntity>>
    @Mock
    private lateinit var tvShowObserver: Observer<List<TVShowEntity>>

    @Before
    fun setUp() {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())
        movieRepository = MovieRepository.getInstance(remoteDataSource)
        movieViewModel = MovieViewModel(movieRepository)
        tvShowViewModel = TVShowViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val movies = movieViewModel.getMovies()

        `when`(movieRepository.getMovies()).thenReturn(movies)
        val movieEntities = movieRepository.getMovies()
        verify(movieRepository).getMovies()
        Assert.assertNotNull(movieEntities)
        assertEquals(movies.value?.size?.toLong(), movieEntities.value?.size?.toLong())

        movieViewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(movies.value)
    }

    @Test
    fun getMovieById() {
        val movies = movieViewModel.getMovies()

        movies.value?.forEach {
            val movie = MutableLiveData<MovieEntity>()
            movie.postValue(it)
            `when`(movieRepository.getMovieById(it.id ?: 0)).thenReturn(movie)
            val movieEntity = movieRepository.getMovieById(it.id ?: 0)
            verify(movieRepository).getMovieById(it.id ?: 0)
            Assert.assertNotNull(movieEntity)
        }

        movieViewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(movies.value)
    }

    @Test
    fun getTVShows() {
        val tvShows = tvShowViewModel.getTVShows()

        `when`(movieRepository.getTVShows()).thenReturn(tvShows)
        val tvShowEntities = movieRepository.getTVShows()
        verify(movieRepository).getTVShows()
        Assert.assertNotNull(tvShowEntities)
        assertEquals(tvShows.value?.size?.toLong(), tvShowEntities.value?.size?.toLong())

        tvShowViewModel.getTVShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(tvShows.value)
    }

    @Test
    fun getTVShowById() {
        val tvShows = tvShowViewModel.getTVShows()

        tvShows.value?.forEach {
            val tvShow = MutableLiveData<TVShowEntity>()
            tvShow.postValue(it)           
            
            `when`(movieRepository.getTVShowById(it.id ?: 0)).thenReturn(tvShow)
            val tvShowEntity = movieRepository.getTVShowById(it.id ?: 0)
            verify(movieRepository).getTVShowById(it.id ?: 0)
            Assert.assertNotNull(tvShowEntity)
        }

        tvShowViewModel.getTVShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(tvShows.value)
    }
}