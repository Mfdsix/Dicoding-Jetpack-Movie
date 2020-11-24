package com.zgenit.vilmu.data.movie

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class MovieListEntity(
        val success: Boolean ?= false,
        var message: String ?= null,
        var datas: List<MovieEntity> ?= arrayListOf()
)