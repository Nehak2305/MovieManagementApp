package com.niit.MovieService.service;

import com.niit.MovieService.domain.Movie;
import com.niit.MovieService.exception.MovieAlreadyExistException;
import com.niit.MovieService.exception.MovieNotFoundException;
import com.niit.MovieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException {
        if ( movieRepository.findById(movie.getMovieId()).isEmpty())
        return movieRepository.save(movie);
        else
        throw new MovieAlreadyExistException();
    }


    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }



    @Override
    public boolean deleteMovie(String id) throws MovieNotFoundException {
        if(movieRepository.findById(id).isEmpty())


            throw new MovieNotFoundException();
        else
            movieRepository.deleteById((id));
        return true;
    }


}
