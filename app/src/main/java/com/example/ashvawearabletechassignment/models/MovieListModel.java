package com.example.ashvawearabletechassignment.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovieListModel implements Serializable {


    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private String id;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("release_date")
    private String releaseDate;


    public MovieListModel(String title, String id, String posterPath, String releaseDate) {
        this.title = title;
        this.id = id;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
