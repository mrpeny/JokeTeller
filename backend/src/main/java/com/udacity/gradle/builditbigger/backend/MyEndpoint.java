package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokesource.JokeSource;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * Endpoint method that provides a Joke with the help of {@link JokeSource} class
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        final JokeSource jokeSource = new JokeSource();

        Joke response = new Joke();
        response.setJoke(jokeSource.getJoke());

        return response;
    }
}
