package com.udacity.gradle.builditbigger.jokesource;

import java.util.Random;

public class JokeSource {
    private final Random mRandomGenerator;
    private String[] jokes = {
            " Knock knock.\n" +
                    "\n" +
                    "Who's there?\n" +
                    "\n" +
                    "Robin.\n" +
                    "\n" +
                    "Robin who?\n" +
                    "\n" +
                    "Robin you, now hand over the cash.",
            "Knock knock.\n" +
                    "\n" +
                    "Who's there?\n" +
                    "\n" +
                    "Etch.\n" +
                    "\n" +
                    "Etch who?\n" +
                    "\n" +
                    "Bless you, friend.",
            "Knock knock.\n" +
                    "\n" +
                    "Who's there?\n" +
                    "\n" +
                    "Alec.\n" +
                    "\n" +
                    "Alec who?\n" +
                    "\n" +
                    "Alec-tricity. Ain't that a shocker?"};

    public JokeSource() {
        mRandomGenerator = new Random();
    }

    /**
     * Returns a random joke.
     */
    public String getJoke() {
        int randomJokeNumber = mRandomGenerator.nextInt(jokes.length);
        return jokes[randomJokeNumber];
    }
}
