package com.zgenit.vilmu.data.tvshow

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class TVShowSingleEntity(
        val success: Boolean ?= false,
        var message: String ?= null,
        val data: TVShowEntity ?= null
)