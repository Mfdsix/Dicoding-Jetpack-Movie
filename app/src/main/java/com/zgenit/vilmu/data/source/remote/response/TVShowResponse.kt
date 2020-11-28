package com.zgenit.vilmu.data.source.remote.response

import com.google.gson.annotations.SerializedName

//
// Created by Mfdsix on 27/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class TVShowResponse(
        @field:SerializedName("id")
        var id: Int ?= 0,

        @field:SerializedName("name")
        var title: String ?= "-",

        @field:SerializedName("overview")
        var overview: String ?= "-",

        @field:SerializedName("poster_path")
        var posterPath: String ?= null,

        @field:SerializedName("vote_average")
        var voteAverage: Double ?= 0.0,

        @field:SerializedName("first_air_date")
        var firstAirDate: String ?= "-",

        @field:SerializedName("original_language")
        var language: String ?= "-",
)
