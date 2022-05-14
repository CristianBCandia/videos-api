package com.api.youtube.videos.dto.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeResponse {

  private String prevPageToken;
  private String nextPageToken;
  private YoutubePageInfo pageInfo;

}
