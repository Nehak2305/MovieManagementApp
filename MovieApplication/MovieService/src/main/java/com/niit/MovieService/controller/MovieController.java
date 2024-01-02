package com.niit.MovieService.controller;

import com.niit.MovieService.domain.Movie;
import com.niit.MovieService.exception.MovieAlreadyExistException;
import com.niit.MovieService.exception.MovieNotFoundException;
import com.niit.MovieService.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class MovieController {
    MovieServiceImpl movieServiceImpl;
    @Autowired
    public MovieController(MovieServiceImpl movieService){
        this.movieServiceImpl=movieService;
    }
    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        try {
            ResponseEntity<?> responseEntity = new ResponseEntity<>(movieServiceImpl.saveMovie(movie), HttpStatus.CREATED);
            return responseEntity;
        }catch (MovieAlreadyExistException ae){
            throw new RuntimeException(ae);
        }
    }
    @GetMapping("/getMovie")
    public ResponseEntity<?> getAllMovie(){
        ResponseEntity<?>responseEntity = new ResponseEntity<>(movieServiceImpl.getAllMovie(), HttpStatus.OK);
        return responseEntity;
    }


   /* @DeleteMapping("/deleteTrack/{id}")
    public ResponseEntity<?>deleteTrackById(@PathVariable String id){
        try{
            ResponseEntity<?>responseEntity = new ResponseEntity<>(movieServiceImpl.deleteMovie(id),HttpStatus.OK);
            return responseEntity;
        }catch (MovieNotFoundException ce){
            throw new RuntimeException(ce);
        }
    }*/


}
