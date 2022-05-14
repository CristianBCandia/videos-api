package com.api.youtube.videos.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Playlist {
  private String id;
  private String title;
  private String channelTitle;

}
