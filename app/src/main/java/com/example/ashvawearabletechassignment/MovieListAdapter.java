package com.example.ashvawearabletechassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieDetailViewHolder> {

    ArrayList<MovieListModel> movieDetails;
    Context context;

    public MovieListAdapter(ArrayList<MovieListModel> movieDetails, Context context) {
        this.movieDetails = movieDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movies_list, parent, false);
        return new MovieDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailViewHolder holder, int position) {
        holder.txtMovieTitle.setText(movieDetails.get(position).getTitle());
//            holder.txtMovieDate.setText(movieDetails.get(position).get());
        holder.txtMovieId.setText(movieDetails.get(position).getId());
        holder.txtReleaseDate.setText(movieDetails.get(position).getReleaseDate());

        String imagePath = movieDetails.get(position).getPosterPath();
        String url = String.format("https://image.tmdb.org/t/p/w780/%s",imagePath);
        Glide.with(context).load(url).into(holder.imgPoster);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailsActivity.class).putExtra("ID", movieDetails.get(position).getId());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieDetails.size();
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {
        TextView txtMovieTitle;
        TextView txtMovieId;
        TextView txtReleaseDate;
        ImageView imgPoster;

        public MovieDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMovieTitle = itemView.findViewById(R.id.movie_title);
            txtMovieId = itemView.findViewById(R.id.movie_date);
            txtReleaseDate = itemView.findViewById(R.id.txtRelease_date);
            imgPoster = itemView.findViewById(R.id.imgPoster);

        }
    }
}
