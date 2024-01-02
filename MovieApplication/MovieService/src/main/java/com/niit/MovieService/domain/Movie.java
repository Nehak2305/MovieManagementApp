package com.niit.MovieService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
    @Id
    private String movieId;
    private String movieName;
    private String genre;
    private String director;
    private int yearOfRelease;
    private int rating;
    private String image_url;
    private String movieTrailer;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String genre, String director, int yearOfRelease, int rating, String image_url, String movieTrailer) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.image_url = image_url;
        this.movieTrailer = movieTrailer;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                ", image_url='" + image_url + '\'' +
                ", movieTrailer='" + movieTrailer + '\'' +
                '}';
    }
}
