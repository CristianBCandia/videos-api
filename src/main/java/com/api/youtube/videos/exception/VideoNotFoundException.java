package com.api.youtube.videos.exception;

public class VideoNotFoundException  extends RuntimeException {

  public VideoNotFoundException(String message) {
    super(message);
  }

  public VideoNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
