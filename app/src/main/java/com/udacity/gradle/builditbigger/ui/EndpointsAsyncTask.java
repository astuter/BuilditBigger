package com.udacity.gradle.builditbigger.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.astuter.ShowJokeActivity;
import com.astuter.builditbigger.jokerbackend.jokerApi.JokerApi;
import com.astuter.builditbigger.jokerbackend.jokerApi.model.JokerBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by astuter on 23/06/16.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokerApi mJokerApi = null;
    private Context mContext;
    private ProgressDialog mProgressDialog;

    public EndpointsAsyncTask(Context context) {
        this.mContext = context;
        mProgressDialog = ProgressDialog.show(mContext, "Getting Joke", "Please wait...", true);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressDialog != null) {
            mProgressDialog.show();
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mJokerApi == null) {  // Only do this once
            JokerApi.Builder builder = new JokerApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1351.appspot.com/_ah/api/");
            mJokerApi = builder.build();
        }
        try {
            return mJokerApi.sayJoke(new JokerBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
//        Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        if (joke != null) {
            ShowJokeActivity(joke);
        } else {
            Toast.makeText(mContext, "Something went wrong while getting jokes.", Toast.LENGTH_LONG).show();
        }
    }

    private void ShowJokeActivity(String joke) {
        Intent intent = new Intent(mContext, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.INTENT_JOKE, joke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}