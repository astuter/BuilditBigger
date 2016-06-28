package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.ui.JokerAsyncTask;

/**
 * Created by aniruddh on 28/06/16.
 */
public class AsyncTaskNonEmptyStringTest extends AndroidTestCase {

    private static final String LOG_TAG = "AsyncTaskNonEmptyTest";

    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v(LOG_TAG, "Running NonEmptyStringTest test");
        String result = null;
        JokerAsyncTask endpointsAsyncTask = new JokerAsyncTask(getContext());
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}