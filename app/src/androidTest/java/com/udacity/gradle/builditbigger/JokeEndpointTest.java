package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeEndpointTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    String joke;

    @Test
    public void checkNonEmptyString() {
        JokeEndpointAsyncTask asyncTask = new JokeEndpointAsyncTask(mActivityTestRule.getActivity());
        asyncTask.execute();
        try {
            Thread.sleep(5000);
            joke = asyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(joke.isEmpty());
    }
}
