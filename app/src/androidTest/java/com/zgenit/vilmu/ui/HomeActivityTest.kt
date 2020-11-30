package com.zgenit.vilmu.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.zgenit.vilmu.R
import com.zgenit.vilmu.ui.home.HomeActivity
import com.zgenit.vilmu.utils.DataDummy
import com.zgenit.vilmu.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//
// Created by Mfdsix on 25/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

class HomeActivityTest {

    private val movies = DataDummy.getMovies()
    private val tvShows = DataDummy.getTVShows()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadDetailMovie() {
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

        onView(withId(R.id.text_movie_language))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_language))
                .check(ViewAssertions.matches(withText(movies[0].language)))

        onView(withId(R.id.text_movie_release_date))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_release_date))
                .check(ViewAssertions.matches(withText(movies[0].releaseDate)))

        onView(withId(R.id.text_movie_score))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_score))
                .check(ViewAssertions.matches(withText(movies[0].voteAverage.toString())))

        onView(withId(R.id.text_movie_overview))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_movie_overview))
                .check(ViewAssertions.matches(withText(movies[0].overview)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("TV Shows")).perform(ViewActions.click())

        onView(withId(R.id.rv_tv_show))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TV Shows")).perform(ViewActions.click())

        onView(withId(R.id.rv_tv_show))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))

        onView(withId(R.id.rv_tv_show)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                        ViewActions.click()
                ))

        onView(withId(R.id.img_tv_show_poster))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_tv_show_background))
                .check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.text_tv_show_title))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_title))
                .check(ViewAssertions.matches(withText(tvShows[0].title)))

        onView(withId(R.id.text_tv_show_language))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_language))
                .check(ViewAssertions.matches(withText(tvShows[0].language)))

        onView(withId(R.id.text_tv_show_first_air_date))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_first_air_date))
                .check(ViewAssertions.matches(withText(tvShows[0].firstAirDate.toString())))

        onView(withId(R.id.text_tv_show_score))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_score))
                .check(ViewAssertions.matches(withText(tvShows[0].voteAverage.toString())))

        onView(withId(R.id.text_tv_show_overview))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_overview))
                .check(ViewAssertions.matches(withText(tvShows[0].overview)))
    }

}