package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInfo {

  private Integer totalResults;
  private Integer resultsPerPage;

}
