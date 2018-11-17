package com.example.jokelib;

import java.util.ArrayList;
import java.util.Random;

public final class JokeDomain {

    private ArrayList<String> jokesList;

    public JokeDomain() {
        jokesList = new ArrayList<>();
        jokesList.add("How do functions break up? They stop calling each other!");
        jokesList.add("When do two functions fight? When they have arguments");
        jokesList.add("What did the flirtatious function say? Call me ;)");
        jokesList.add("What is a programmer's favorite hangout place ? Foo Bar");
        jokesList.add("There are only 10 kinds of people in this world: those who know binary and those who don’t.");
    }

    public String getJoke() {
        Random r = new Random();
        return jokesList.get(r.nextInt(jokesList.size()));
    }
}
