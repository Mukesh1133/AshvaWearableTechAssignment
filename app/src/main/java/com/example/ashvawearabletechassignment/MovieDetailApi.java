package com.example.ashvawearabletechassignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDetailApi {

    //https://api.themoviedb.org/3/movie/284052?api_key=55957fcf3ba81b137f8fc01ac5a31fb5

    @GET("3/movie/{id}?api_key=55957fcf3ba81b137f8fc01ac5a31fb5")
    Call<MovieDetailModel> getDetail(@Path("id")String id);
}
