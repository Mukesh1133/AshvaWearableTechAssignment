package com.example.ashvawearabletechassignment.models;

import com.example.ashvawearabletechassignment.models.GenreModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieDetailModel implements Serializable {
    @SerializedName("adult")
    private String adult;
    @SerializedName("title")
    private String title;
    @SerializedName("budget")
    private String budget;
    @SerializedName("genres")
    private ArrayList<GenreModel> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("revenue")
    private String revenue;
    @SerializedName("runtime")
    private String runTime;
    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("overview")
    private String overView;


    public MovieDetailModel(String adult, String title, String budget, ArrayList<GenreModel> genres, String homepage, String posterPath, String revenue, String tagline, String voteAverage, String voteCount, String status, String releaseDate, String overView) {
        this.adult = adult;
        this.title = title;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.originalLanguage = posterPath;
        this.revenue = revenue;
        this.runTime = tagline;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.backdropPath = status;
        this.releaseDate = releaseDate;
        this.overView = overView;
    }

    public MovieDetailModel(String posterPath, String adult, String voteAverage, String title, String overView) {
        this.originalLanguage = posterPath;
        this.adult = adult;
        this.voteAverage = voteAverage;
        this.title = title;
        this.overView = overView;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public ArrayList<GenreModel> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenreModel> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }
}
