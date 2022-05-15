package com.api.youtube.videos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = {CustomBadRequestException.class})
  public ResponseEntity<Object> handleBadRequest(CustomBadRequestException ex) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    ApiException apiException = new ApiException(
      ex.getMessage(),
      HttpStatus.BAD_REQUEST,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(apiException, badRequest);
  }

  @ExceptionHandler(value = {CustomServerErrorException.class})
  public ResponseEntity<Object> hadleServerError(CustomServerErrorException ex) {
    HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
    ApiException apiException = new ApiException(
      ex.getMessage(),
      HttpStatus.INTERNAL_SERVER_ERROR,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(apiException, serverError);
  }

  @ExceptionHandler(value = {VideoNotFoundException.class})
  public ResponseEntity<Object> hadleVideoNotFound(VideoNotFoundException ex) {
    HttpStatus serverError = HttpStatus.NOT_FOUND;
    ApiException apiException = new ApiException(
      ex.getMessage(),
      HttpStatus.NOT_FOUND,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(apiException, serverError);
  }
}
