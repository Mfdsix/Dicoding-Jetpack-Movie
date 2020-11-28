package com.zgenit.vilmu.di

import android.content.Context
import com.zgenit.vilmu.data.source.MovieRepository
import com.zgenit.vilmu.utils.JsonHelper

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        return MovieRepository.getInstance(JsonHelper(context))
    }
}
