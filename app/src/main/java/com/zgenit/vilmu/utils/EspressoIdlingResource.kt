package com.zgenit.vilmu.utils

import androidx.test.espresso.idling.CountingIdlingResource

//
// Created by Mfdsix on 01/12/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }
}