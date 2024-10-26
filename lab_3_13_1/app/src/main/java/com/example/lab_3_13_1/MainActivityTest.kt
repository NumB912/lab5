package com.example.lab_3_13_1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testEvenNumber() {
        onView(withId(R.id.editTextNumber)).perform(typeText("4"))
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText("Even Number")))
    }

    @Test
    fun testOddNumber() {
        onView(withId(R.id.editTextNumber)).perform(typeText("5"))
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText("Odd Number")))
    }

    @Test
    fun testInvalidInput() {
        onView(withId(R.id.editTextNumber)).perform(typeText("abc"))
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText("Please enter a valid number")))
    }
}
