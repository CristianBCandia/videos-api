package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistResponse {
  private List<Playlist> playlists;
  private Integer total;
  private String nextPage;
  private String prevPage;

}
