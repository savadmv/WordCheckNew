package com.test.wordcheck;

import android.app.Application;

import com.test.wordcheck.Model.WordResponse;

public class App extends Application {
    public  WordResponse wordResponse;
    public App() {
    }

    public  WordResponse getWordResponse() {
        return wordResponse;
    }

    public void setWordResponse(WordResponse wordResponse) {
        this.wordResponse = wordResponse;
    }
}
