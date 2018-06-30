package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.jokedisplay.JokeActivity;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static final String ROOT_URL = "http://10.0.2.2:8080/_ah/api/";

    private Context context;
    private MyApi myApiService = null;

    @Override
    protected String doInBackground(Context... contexts) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(ROOT_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        this.context = contexts[0];

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent jokeDisplayIntent = new Intent(context, JokeActivity.class);
        jokeDisplayIntent.putExtra(JokeActivity.JOKE_KEY, joke);
        context.startActivity(jokeDisplayIntent);
    }
}
