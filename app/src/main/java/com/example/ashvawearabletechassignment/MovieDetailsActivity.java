package com.example.ashvawearabletechassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    TextView txtGenre;
    TextView txtRating;
    TextView txtTitle;
    TextView txtOverView;
    Context context;

    RecyclerView recyclerView;
    MovieDetailAdapter movieDetailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imgMoviePoster = findViewById(R.id.imgMoviePoster);
        txtAgeRestrict = findViewById(R.id.txtAgeRestrict);
        txtGenre = findViewById(R.id.txtGenre);
        txtRating = findViewById(R.id.txtRating);
        txtTitle = findViewById(R.id.txtTitle);
        txtOverView = findViewById(R.id.txtOverView);

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
                String imgPath = movieDetailModel.getPosterPath();
                String ageRestrict = movieDetailModel.getAdult();
                String rating = movieDetailModel.getVoteAverage();
                String overView = movieDetailModel.getOverView();
                Log.d("RESPONSE","RESPONSEDATA" +title);
                List<GenreModel> genreList = movieDetailModel.getGenres();
                ArrayList<GenreModel> genreModels= new ArrayList<>();

                for(int i=0; i<genreList.size();i++){
                    String genreType = genreList.get(i).getName();

                    genreModels.add(new GenreModel(genreType));
                }



                txtRating.setText(movieDetailModel.getVoteAverage());
                txtTitle.setText(movieDetailModel.getTitle());
                txtOverView.setText(movieDetailModel.getOverView());

                if(ageRestrict.equals("false")){
                    txtAgeRestrict.setText("16+");
                }else{
                    txtAgeRestrict.setText("18+");
                }

                String imagePath =movieDetailModel.getPosterPath();
                String url = String.format("https://image.tmdb.org/t/p/w780/%s",imagePath);
//                Glide.with(context).load(url).into(imgMoviePoster);
                Picasso.get().load(url).placeholder(R.drawable.movie).into(imgMoviePoster);

                movieDetailAdapter = new MovieDetailAdapter(genreModels,MovieDetailsActivity.this);
                recyclerView.setAdapter(movieDetailAdapter);
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                    Log.d("TAG1", "FAILED"+ t);
            }
        });


    }
}