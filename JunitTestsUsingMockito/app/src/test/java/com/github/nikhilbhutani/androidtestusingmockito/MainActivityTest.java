package com.github.nikhilbhutani.androidtestusingmockito;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Nikhil Bhutani on 9/11/2016.
 */
public class MainActivityTest {

    Context context;
    Intent intent;

    // NOTE : WILL ADD MORE MOCKITO SCENARIOS SOON

    @Before
    public void setup(){
        context = Mockito.mock(Context.class);
        intent = MainActivity.createQuery(context);


    }


    @Test
    public void testingIntent(){

        assertNotNull(intent);

    }


}
