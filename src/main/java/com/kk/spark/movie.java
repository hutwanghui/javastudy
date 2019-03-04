package com.kk.spark;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by hutwanghui on 2018/10/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class movie {
    public static void main(String[] args) {
        TmdbMovies movies = new TmdbApi("c2f8fe5b024fded37dbb4202e5657ebd").getMovies();
        MovieDb movie = movies.getMovie(5353, "en");
        System.out.println(movie.toString());
    }
}
