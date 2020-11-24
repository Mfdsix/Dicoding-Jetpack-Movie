package com.zgenit.vilmu.ui.tvshow

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

//
// Created by Mfdsix on 24/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class TVShowViewModelTesting {

    private  lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp(){
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShows(){
        val tvShows = viewModel.getTVShows()

        TestCase.assertNotNull(tvShows)
        Assert.assertNotEquals(false, tvShows.success)
        Assert.assertNotEquals(0, tvShows.datas?.size ?: 0)
        TestCase.assertTrue("TV Show Data Not More Than 10 ", tvShows.datas?.size ?: 0 >= 10)
    }

    @Test
    fun getTVShowById(){
        val tvShowEntities = viewModel.getTVShows()

        tvShowEntities.datas?.forEach {
            val tvShowEntity = viewModel.getTVShowVById(it.id ?: 0)

            Assert.assertNotEquals(false, tvShowEntity.success)
            TestCase.assertNotNull(tvShowEntity)
        }
    }
}