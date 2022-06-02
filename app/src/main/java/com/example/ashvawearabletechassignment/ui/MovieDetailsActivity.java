package com.example.ashvawearabletechassignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashvawearabletechassignment.R;
import com.example.ashvawearabletechassignment.models.GenreModel;
import com.example.ashvawearabletechassignment.models.MovieDetailModel;
import com.example.ashvawearabletechassignment.remote.MovieDetailApi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView imgMoviePoster;
    TextView txtAgeRestrict;
    TextView txtLang;
    TextView txtRating;
    TextView txtTitle;
    TextView txtOverView;
    TextView txtDuration;
    Context context;

    RecyclerView recyclerView;
    MovieGenreAdapter movieDetailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imgMoviePoster = findViewById(R.id.imgMoviePoster);
        txtAgeRestrict = findViewById(R.id.txtAgeRestrict);
        txtLang = findViewById(R.id.txtLang);
        txtRating = findViewById(R.id.txtRating);
        txtTitle = findViewById(R.id.txtTitle);
        txtOverView = findViewById(R.id.txtOverView);
        txtDuration = findViewById(R.id.txtDuration);

        recyclerView = findViewById(R.id.rvGenre);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        String id = getIntent().getStringExtra("ID");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieDetailApi movieDetailApi = retrofit.create(MovieDetailApi.class);

        Call<MovieDetailModel> call = movieDetailApi.getDetail(id);

        call.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
                MovieDetailModel movieDetailModel = response.body();


                String title = movieDetailModel.getTitle();
                String imgPath = movieDetailModel.getOriginalLanguage();
                String ageRestrict = movieDetailModel.getAdult();
                String rating = movieDetailModel.getVoteAverage();
                String overView = movieDetailModel.getOverView();
                Log.d("RESPONSE", "RESPONSEDATA" + title);
                List<GenreModel> genreList = movieDetailModel.getGenres();
                ArrayList<GenreModel> genreModels = new ArrayList<>();

                for (int i = 0; i < genreList.size(); i++) {
                    String genreType = genreList.get(i).getName();

                    genreModels.add(new GenreModel(genreType));
                }


                txtRating.setText(movieDetailModel.getVoteAverage());
                txtTitle.setText(movieDetailModel.getTitle());
                txtOverView.setText(movieDetailModel.getOverView());
                txtDuration.setText(movieDetailModel.getRunTime() + " m");

                if (ageRestrict.equals("false")) {
                    txtAgeRestrict.setText("13+");
                } else {
                    txtAgeRestrict.setText("18+");
                }
                txtLang.setText(movieDetailModel.getOriginalLanguage());

                String imagePath = movieDetailModel.getBackdropPath();
                String url = String.format("https://image.tmdb.org/t/p/w780/%s", imagePath);
//                Glide.with(context).load(url).into(imgMoviePoster);
                Picasso.get().load(url).placeholder(R.drawable.movie).into(imgMoviePoster);

                movieDetailAdapter = new MovieGenreAdapter(genreModels, MovieDetailsActivity.this);
                recyclerView.setAdapter(movieDetailAdapter);
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                Log.d("TAG1", "FAILED" + t);
            }
        });


    }
}