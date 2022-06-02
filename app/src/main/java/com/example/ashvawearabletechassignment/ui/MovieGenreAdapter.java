package com.example.ashvawearabletechassignment.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashvawearabletechassignment.R;
import com.example.ashvawearabletechassignment.models.GenreModel;

import java.util.ArrayList;

public class MovieGenreAdapter extends RecyclerView.Adapter<MovieGenreAdapter.MovieDetailViewHolder> {

    ArrayList<GenreModel> genreModels;
    Context context;

    public MovieGenreAdapter(ArrayList<GenreModel> genreModels, Context context) {
        this.genreModels = genreModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieGenreAdapter.MovieDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_movie_genre, parent, false);
        return new MovieDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieGenreAdapter.MovieDetailViewHolder holder, int position) {
        holder.txtGenre.setText(genreModels.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return genreModels.size();
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {

        TextView txtGenre;

        public MovieDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            txtGenre = itemView.findViewById(R.id.txtGenre);
        }
    }
}
