package com.api.youtube.videos.dto.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubePageInfo {

  private Integer totalResults;
  private Integer resultsPerPage;

}
