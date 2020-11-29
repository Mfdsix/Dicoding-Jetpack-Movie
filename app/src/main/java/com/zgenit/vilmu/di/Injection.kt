package com.zgenit.vilmu.di

import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.data.source.remote.RemoteDataSource
import com.zgenit.vilmu.utils.JsonHelper

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

object Injection {
    fun provideRepository(): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper())
        return MovieRepository.getInstance(remoteDataSource)
    }
}
