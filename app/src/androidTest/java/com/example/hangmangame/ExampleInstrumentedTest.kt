package com.example.hangmangame

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import android.content.res.Configuration
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.hangmangame", appContext.packageName)
    }

    @Test
    fun completeWordAndWinTest() {

        val scenario = ActivityScenario.launch(MainActivity2::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.button))
            .perform(ViewActions.click())

        val letters = listOf('A', 'P', 'P', 'L', 'E')

        for (letter in letters) {
            Espresso.onView(ViewMatchers.withText(letter.toString()))
                .perform(ViewActions.click())
        }

        Thread.sleep(3000)

        scenario.close()
    }

    @Test
    fun hintButtonVisibilityTest() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        context.resources.configuration.orientation = Configuration.ORIENTATION_PORTRAIT
        val scenarioPortrait = ActivityScenario.launch(MainActivity2::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.button))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.hintButton))
            .check(ViewAssertions.doesNotExist())

        Thread.sleep(3000)
        scenarioPortrait.close()
    }



}