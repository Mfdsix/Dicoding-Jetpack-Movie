package com.zgenit.vilmu.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import com.zgenit.vilmu.utils.DataDummy
import com.zgenit.vilmu.utils.LiveDataTestUtil
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.getMovies()
    private val tvShowResponses = DataDummy.getTVShows()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                    .onMoviesReceived(movieResponses)
            null
        }.`when`(remote).getMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovies())
        com.nhaarman.mockitokotlin2.verify(remote).getMovies(any())
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        val movies = movieResponses

        movies.forEach {
            val movieId = it.id ?: 0
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieByIdCallback)
                        .onMovieByIdReceived(it)
                null
            }.`when`(remote).getMovieById(eq(movieId), any())
            val movieEntity = LiveDataTestUtil.getValue(movieRepository.getMovieById(movieId))
            com.nhaarman.mockitokotlin2.verify(remote).getMovieById(eq(movieId), any())
            Assert.assertNotNull(movieEntity)
        }
    }

    @Test
    fun getTVShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVShowsCallback)
                    .onTVShowsReceived(tvShowResponses)
            null
        }.`when`(remote).getTVShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getTVShows())
        com.nhaarman.mockitokotlin2.verify(remote).getTVShows(any())
        Assert.assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTVShowById() {
        val tvShows = tvShowResponses

        tvShows.forEach {
            val tvShowId = it.id ?: 0
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTVShowByIdCallback)
                        .onTVShowByIdReceived(it)
                null
            }.`when`(remote).getTVShowById(eq(tvShowId), any())
            val tvShowEntity = LiveDataTestUtil.getValue(movieRepository.getTVShowById(tvShowId))
            com.nhaarman.mockitokotlin2.verify(remote).getTVShowById(eq(tvShowId), any())
            Assert.assertNotNull(tvShowEntity)
        }
    }

}