package com.test.wordcheck;

import com.test.wordcheck.Model.WordResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface  {

    @GET()
    Call<WordResponse> getEveryThing(@Header("X-RapidAPI-Key") String authKey,@Url String url);
}
