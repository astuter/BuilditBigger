package com.astuter.builditbigger.JokerBackend;

import com.astuter.Joker;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokerBean {

    private Joker jokerLib;

    public JokerBean() {
        jokerLib = new Joker();
    }

    public String getJoke() {
        return jokerLib.getJoke();
    }
}