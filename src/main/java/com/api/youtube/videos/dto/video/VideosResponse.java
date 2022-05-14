package com.api.youtube.videos.dto.video;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VideosResponse {

  private List<Video> videos;
  private Integer total;
  private String nextPage;
  private String prevPage;

}
