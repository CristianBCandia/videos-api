package com.api.youtube.videos.dto.youtube;

import com.api.youtube.videos.dto.playlist.PlaylistSnippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubePlaylist {
  private String id;
  private PlaylistSnippet snippet;
}
