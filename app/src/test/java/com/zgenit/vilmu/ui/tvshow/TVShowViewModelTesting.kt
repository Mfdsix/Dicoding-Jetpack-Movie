package com.zgenit.vilmu.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity
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
        viewModel = TVShowViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyTVShows = DataDummy.getTVShows()
        val tvShows = MutableLiveData<List<TVShowEntity>>()
        tvShows.value = dummyTVShows

        Mockito.`when`(movieRepository.getTVShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTVShows().value
        Mockito.verify(movieRepository).getTVShows()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(11, tvShowEntities?.size)
        Assert.assertNotEquals(0, tvShowEntities?.size)
        TestCase.assertTrue("TV Show Data Not More Than 10 ", tvShowEntities?.size ?: 0 >= 10)

        viewModel.getTVShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTVShows)
    }

    @Test
    fun getMovieById(){
        val tvShows = DataDummy.getTVShows()

        tvShows.forEach {
            val tvShowId = it.id ?: 0
            val dummyTVShow = DataDummy.getTVShowById(tvShowId)
            val tvShow = MutableLiveData<TVShowEntity>()
            tvShow.value = dummyTVShow

            Mockito.`when`(movieRepository.getTVShowById(tvShowId)).thenReturn(tvShow)
            val movieEntity = viewModel.getTVShowVById(tvShowId).value
            Mockito.verify(movieRepository).getTVShowById(tvShowId)
            Assert.assertNotNull(movieEntity)
        }
    }
}