package com.niit.MovieService.repository;

import com.niit.MovieService.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {

}
