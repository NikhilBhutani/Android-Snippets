package com.github.nikhilbhutani.androidtestusingrobolectric;

import android.app.Activity;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
/**
 * Created by Nikhil Bhutani on 9/10/2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private Activity mainActivity;

    @Before
    public void setup(){
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void checkActivityNotNull() throws Exception {


        assertNotNull(mainActivity);
    }
    @Test
    public void onClickButtonShowsToast() throws Exception{
        Button button = (Button)mainActivity.findViewById(R.id.button);
        assertNotNull(button);
        button.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Test Successful"));
    }

}
