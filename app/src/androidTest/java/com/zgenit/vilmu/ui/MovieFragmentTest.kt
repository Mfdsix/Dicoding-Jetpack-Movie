package com.zgenit.vilmu.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.zgenit.vilmu.R
import com.zgenit.vilmu.ui.home.HomeActivity
import com.zgenit.vilmu.utils.DataDummy
import org.junit.Rule
import org.junit.Test

//
// Created by Mfdsix on 25/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class MovieFragmentTest {

    private val movies = DataDummy.getMovies()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))

        loadDetailMovie()
    }

    private fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))

        onView(withId(R.id.img_movie_poster))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_movie_background))
                .check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.text_movie_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_title))
            .check(ViewAssertions.matches(withText(movies[0].title)))

        onView(withId(R.id.text_movie_category))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_category))
                .check(ViewAssertions.matches(withText(movies[0].category)))

        onView(withId(R.id.text_movie_year))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_year))
                .check(ViewAssertions.matches(withText(movies[0].year.toString())))

        onView(withId(R.id.text_movie_director))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_director))
                .check(ViewAssertions.matches(withText(movies[0].director)))

        onView(withId(R.id.text_movie_duration))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_duration))
                .check(ViewAssertions.matches(withText(movies[0].duration)))

        onView(withId(R.id.text_movie_score))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_score))
                .check(ViewAssertions.matches(withText("${movies[0].userScore}%")))

        onView(withId(R.id.text_movie_overview))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_overview))
                .check(ViewAssertions.matches(withText(movies[0].description)))
    }

}