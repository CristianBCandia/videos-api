package com.api.youtube.videos.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistResponse {
  private List<Playlist> playlists;
  private Integer total;
  private String nextPage;
  private String prevPage;

}
