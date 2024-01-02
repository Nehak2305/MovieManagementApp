package com.niit.MovieService.service;

import com.niit.MovieService.domain.Movie;
import com.niit.MovieService.exception.MovieAlreadyExistException;
import com.niit.MovieService.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie) throws MovieAlreadyExistException;

    List<Movie> getAllMovie();

    boolean deleteMovie(String id) throws MovieNotFoundException;

}
