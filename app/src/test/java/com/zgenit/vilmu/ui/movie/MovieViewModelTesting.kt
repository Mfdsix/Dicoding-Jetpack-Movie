package com.zgenit.vilmu.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.utils.DataDummy
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTesting {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.getMovies()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepository.getMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(movieRepository).getMovies()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(11, movieEntities?.size)
        Assert.assertNotEquals(0, movieEntities?.size)
        TestCase.assertTrue("Movie Data Not More Than 10 ", movieEntities?.size ?: 0 >= 10)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getMovieById(){
        val movies = DataDummy.getMovies()

        movies.forEach {
            val movieId = it.id ?: 0
            val dummyMovie = DataDummy.getMovieById(movieId)
            val movie = MutableLiveData<MovieEntity>()
            movie.value = dummyMovie

            Mockito.`when`(movieRepository.getMovieById(movieId)).thenReturn(movie)
            val movieEntity = viewModel.getMovieById(movieId).value
            Mockito.verify(movieRepository).getMovieById(movieId)
            Assert.assertNotNull(movieEntity)
        }
    }
}