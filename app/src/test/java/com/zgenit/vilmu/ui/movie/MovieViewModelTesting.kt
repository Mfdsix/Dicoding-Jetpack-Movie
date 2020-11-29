package com.zgenit.vilmu.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import com.zgenit.vilmu.utils.JsonHelper
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

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
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())
        movieRepository = MovieRepository(remoteDataSource)
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies(){
        val movieEntities = viewModel.getMovies()

        assertNotNull(movieEntities.value)
        assertNotEquals(0, movieEntities.value?.size)
        assertTrue("Movies Data Not More Than 10 ", movieEntities.value?.size ?: 0 >= 10)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(movieEntities.value)
    }

    @Test
    fun getMovieById(){
        val movieEntities = viewModel.getMovies()

        movieEntities.value?.forEach {
            val movieEntity = viewModel.getMovieById(it.id ?: 0)
            assertNotNull(movieEntity)
        }

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(movieEntities.value)
    }
}