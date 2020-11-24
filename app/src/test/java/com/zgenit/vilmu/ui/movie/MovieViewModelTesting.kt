package com.zgenit.vilmu.ui.movie

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieViewModelTesting {

    private  lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies(){
        val movieEntities = viewModel.getMovies()

        assertNotNull(movieEntities)
        assertNotEquals(false, movieEntities.success)
        assertNotEquals(0, movieEntities.datas?.size ?: 0)
        assertTrue("Movies Data Not More Than 10 ", movieEntities.datas?.size ?: 0 >= 10)
    }

    @Test
    fun getMovieById(){
        val movieEntities = viewModel.getMovies()

        movieEntities.datas?.forEach {
            val movieEntity = viewModel.getMovieById(it.id ?: 0)

            assertNotEquals(false, movieEntity.success)
            assertNotNull(movieEntity)
        }
    }
}