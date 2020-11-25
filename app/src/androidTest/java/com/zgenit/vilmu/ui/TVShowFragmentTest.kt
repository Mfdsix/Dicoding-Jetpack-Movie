package com.zgenit.vilmu.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
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

class TVShowFragmentTest {

    private val tvShows = DataDummy.getTVShows()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadTVShows() {
        onView(withText("TV Shows")).perform(click())

        onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))

        loadDetailTVShow()
    }

    private fun loadDetailTVShow() {
        onView(withId(R.id.rv_tv_show)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                        click()
                ))

        onView(withId(R.id.img_tv_show_poster))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_tv_show_background))
                .check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.text_tv_show_title))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_title))
                .check(ViewAssertions.matches(withText(tvShows[0].title)))

        onView(withId(R.id.text_tv_show_category))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_category))
                .check(ViewAssertions.matches(withText(tvShows[0].category)))

        onView(withId(R.id.text_tv_show_year))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_year))
                .check(ViewAssertions.matches(withText(tvShows[0].year.toString())))

        onView(withId(R.id.text_tv_show_duration))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_duration))
                .check(ViewAssertions.matches(withText(tvShows[0].duration)))

        onView(withId(R.id.text_tv_show_score))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_score))
                .check(ViewAssertions.matches(withText("${tvShows[0].userScore}%")))

        onView(withId(R.id.text_tv_show_overview))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_tv_show_overview))
                .check(ViewAssertions.matches(withText(tvShows[0].description)))
    }

}