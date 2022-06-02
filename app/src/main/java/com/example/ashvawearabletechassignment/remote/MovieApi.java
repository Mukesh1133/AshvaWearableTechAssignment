package com.example.ashvawearabletechassignment.remote;

import com.example.ashvawearabletechassignment.models.MoviesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    //3/movie/now_playing?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=undefined
    @GET("3/movie/now_playing?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=3")
    Call<MoviesResponseModel> getData();
}
