package com.example.ashvawearabletechassignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ashvawearabletechassignment.remote.MovieApi;
import com.example.ashvawearabletechassignment.R;
import com.example.ashvawearabletechassignment.models.MovieListModel;
import com.example.ashvawearabletechassignment.models.MoviesResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieListAdapter movieDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovieList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));


        Retrofit retrofit = new Retrofit.Builder()
                //https://api.themoviedb.org/
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);

        Call<MoviesResponseModel> call = movieApi.getData();

        call.enqueue(new Callback<MoviesResponseModel>() {
            @Override
            public void onResponse(Call<MoviesResponseModel> call, Response<MoviesResponseModel> response) {
                Log.d("Tag", "tag " + response.body());
                MoviesResponseModel moviesResponse = response.body();
                List<MovieListModel> movieDetails = moviesResponse.getResults();
                ArrayList<MovieListModel> movieDetails1 = new ArrayList<>();
                for (int i = 0; i < movieDetails.size(); i++) {
                    Log.d("DATA", "DATA: " + movieDetails.get(i).getTitle());
                    String title = movieDetails.get(i).getTitle();
                    String id = movieDetails.get(i).getId();
                    String posterPath = movieDetails.get(i).getPosterPath();
                    String releaseDate = movieDetails.get(i).getReleaseDate();

                    Log.d("TAG", "TAG" + title);
                    Log.d("TAG", "TAG" + id);

                    movieDetails1.add(new MovieListModel(title, id, posterPath, releaseDate));
                }
                movieDetailAdapter = new MovieListAdapter(movieDetails1, MainActivity.this);
                recyclerView.setAdapter(movieDetailAdapter);

            }

            @Override
            public void onFailure(Call<MoviesResponseModel> call, Throwable t) {
                Log.d("Tag1", "tag" + t);
            }
        });


    }
}
