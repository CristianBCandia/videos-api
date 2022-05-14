package com.api.youtube.videos.dto.video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideosResponse {

  private List<Video> videos;
  private Integer total;
  private String nextPage;
  private String prevPage;

}
