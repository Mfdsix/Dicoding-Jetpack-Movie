package com.zgenit.vilmu.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import com.zgenit.vilmu.utils.JsonHelper
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowViewModelTesting {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository
    @Mock
    private lateinit var observer: Observer<List<TVShowEntity>>

    @Before
    fun setUp() {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())
        movieRepository = MovieRepository(remoteDataSource)
        viewModel = TVShowViewModel(movieRepository)
    }

    @Test
    fun getTVShows(){
        val tvShowEntities = viewModel.getTVShows()

        TestCase.assertNotNull(tvShowEntities.value)
        Assert.assertNotEquals(0, tvShowEntities.value?.size)
        TestCase.assertTrue("TV Show Data Not More Than 10 ", tvShowEntities.value?.size ?: 0 >= 10)

        viewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(tvShowEntities.value)
    }

    @Test
    fun getTVShowById(){
        val tvShowEntities = viewModel.getTVShows()

        tvShowEntities.value?.forEach {
            val tvShowEntity = viewModel.getTVShowVById(it.id ?: 0)
            TestCase.assertNotNull(tvShowEntity)
        }

        viewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(tvShowEntities.value)
    }
}