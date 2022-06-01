package com.example.ashvawearabletechassignment;

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
    @SerializedName("backdrop_path")
    private String posterPath;
    @SerializedName("revenue")
    private String revenue;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("status")
    private String status;
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
        this.posterPath = posterPath;
        this.revenue = revenue;
        this.tagline = tagline;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.status = status;
        this.releaseDate = releaseDate;
        this.overView = overView;
    }

    public MovieDetailModel(String posterPath,String adult,String voteAverage,String title,String overView){
        this.posterPath = posterPath;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
