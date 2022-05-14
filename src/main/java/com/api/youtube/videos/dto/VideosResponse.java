package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VideosResponse {

  private List<Video> videos;
  private Integer total;

}
