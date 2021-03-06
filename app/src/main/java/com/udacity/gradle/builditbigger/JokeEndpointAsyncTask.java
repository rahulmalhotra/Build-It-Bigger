package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeEndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private String TAG = getClass().getSimpleName();
    private MyApi jokeApiService = null;
    private Context context;
    JokeApiResponse response;

    public JokeEndpointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(jokeApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            jokeApiService = builder.build();
        }

        try {
            return jokeApiService.getJoke().execute().getData();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        response = (JokeApiResponse) context;
        response.getJoke(result);
        super.onPostExecute(result);
    }
}
