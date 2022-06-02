package com.example.ashvawearabletechassignment.models;

import java.io.Serializable;
import java.util.List;

public class MoviesResponseModel implements Serializable {

    private int page;

    private List<MovieListModel> results;

    public MoviesResponseModel(int date, List<MovieListModel> movieDetailsList) {
        this.page = date;
        this.results = movieDetailsList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieListModel> getResults() {
        return results;
    }

    public void setResults(List<MovieListModel> results) {
        this.results = results;
    }

    public int getDate() {
        return page;
    }

    public void setDate(int date) {
        this.page = date;
    }
}
