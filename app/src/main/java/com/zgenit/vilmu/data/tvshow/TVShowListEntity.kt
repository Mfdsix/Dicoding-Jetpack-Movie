package com.zgenit.vilmu.data.tvshow

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class TVShowListEntity(
        val success: Boolean ?= false,
        val message: String ?= null,
        val datas: List<TVShowEntity> ?= arrayListOf()
)