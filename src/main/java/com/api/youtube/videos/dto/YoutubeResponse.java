package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeResponse {

  private String prevPageToken;
  private String nextPageToken;
  private YoutubePageInfo pageInfo;

}
