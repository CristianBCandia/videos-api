package com.api.youtube.videos.exception;

public class CustomServerErrorException extends RuntimeException {

  public CustomServerErrorException(String message) {
    super(message);
  }

  public CustomServerErrorException(String message, Throwable cause) {
    super(message, cause);
  }
}
