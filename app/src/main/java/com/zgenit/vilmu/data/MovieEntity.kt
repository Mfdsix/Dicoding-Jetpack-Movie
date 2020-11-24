package com.zgenit.vilmu.data

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

data class MovieEntity(
    var id: Int ?= 0,
    var title: String ?= "-",
    var description: String ?= "-",
    var year: Int ?= 0,
    var img: String ?= null,
    var category: String ?= "-",
    var userScore: Int ?= 0,
    var duration: String ?= "-",
    var director: String ?= "-",
)