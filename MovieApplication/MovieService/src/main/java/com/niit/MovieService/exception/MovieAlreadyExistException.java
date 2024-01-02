package com.niit.MovieService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Movie Already Exist")
public class MovieAlreadyExistException extends Exception{
}
