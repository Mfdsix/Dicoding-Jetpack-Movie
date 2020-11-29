package com.zgenit.vilmu.data.source.local.entity

import com.google.gson.annotations.SerializedName

//
// Created by Mfdsix on 29/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class MovieEntity(
    var id: Int ?= 0,
    var title: String ?= "-",
    var overview: String ?= "-",
    var posterPath: String ?= null,
    var voteAverage: Double ?= 0.0,
    var releaseDate: String ?= "-",
    var language: String ?= "-",
)