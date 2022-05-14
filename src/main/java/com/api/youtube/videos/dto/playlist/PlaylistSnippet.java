package com.api.youtube.videos.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistSnippet {
  private String title;
  private String channelTitle;
}
