package com.hdd.criminalitent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
    }


    @Test
    fun typeCrimeTitle() {

        scenario.onFragment { fragment ->
            assertEquals(fragment.crime.title, "")
        }

        onView(withId(R.id.crime_title)).perform(typeText("HAPPY CODING"))

        onView(withId(R.id.crime_title)).check(matches(withText("HAPPY CODING")))

        scenario.onFragment { fragment ->
            assertEquals(fragment.crime.title, "HAPPY CODING")
        }
    }

    @Test
    fun toggleCheckBox() {
        scenario.onFragment { fragment ->
            assertFalse(fragment.crime.isSolved)
        }
        onView(withId(R.id.crime_solved)).check(matches(isNotChecked()))

        onView(withId(R.id.crime_solved)).perform(click())

        onView(withId(R.id.crime_solved)).check(matches(isChecked()))
        scenario.onFragment { fragment ->
            assertTrue(fragment.crime.isSolved)
        }
    }
}