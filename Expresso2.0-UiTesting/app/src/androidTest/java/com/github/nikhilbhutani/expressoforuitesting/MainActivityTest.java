package com.github.nikhilbhutani.expressoforuitesting;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Nikhil Bhutani on 9/13/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTestChangesWork(){

        //Type text and press the button
         onView(withId(R.id.inputField))
         .perform(typeText("HELLO"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));

     }



}
