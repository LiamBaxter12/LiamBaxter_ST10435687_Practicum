package com.example.practical

import android.content.Intent
import androidx.test.espresso.action.ViewActions


import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLaunchMainActivity() {
        Espresso.onView(withId(R.id.button)).perform(click())
        // Add assertions or further actions if needed
    }

@RunWith(AndroidJUnit4::class)
class Weather1Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(Weather1::class.java)

    @Test
    fun testLaunchWeather1Activity() {
        // Simulate entering data and performing actions on Weather1 screen
        // For example:
        Espresso.onView(withId(R.id.days)).perform(ViewActions.typeText("Monday"))
        Espresso.onView(withId(R.id.max1)).perform(ViewActions.typeText("30"))
        Espresso.onView(withId(R.id.min)).perform(ViewActions.typeText("20"))
        Espresso.onView(withId(R.id.weather)).perform(ViewActions.typeText("Sunny"))
        Espresso.onView(withId(R.id.button)).perform(click())
        // Add assertions or further actions if needed
    }
}




@RunWith(AndroidJUnit4::class)
class Screen2Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(Screen2::class.java)

    @Test
    fun testLaunchScreen2Activity() {
        // Simulate receiving intent extras and displaying data on Screen2
        // For example:
        arrayListOf("Monday", "Tuesday")
        arrayListOf(30, 32)
        arrayListOf(20, 22)
        arrayListOf("Sunny", "Cloudy")

        val intent = Intent().apply {
            putStringArrayListExtra()
            putIntegerArrayListExtra()
            putIntegerArrayListExtra()
            putStringArrayListExtra()
        }
        activityRule.scenario.onActivity { activity ->
            activity.intent = intent
        }
        // Add assertions or further actions if needed
    }

    private fun putStringArrayListExtra() {
        TODO("Not yet implemented")
    }

    private fun putIntegerArrayListExtra() {
        TODO("Not yet implemented")
    }
}}
