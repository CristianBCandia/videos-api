package com.api.youtube.videos.dto.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeVideosResponse extends YoutubeResponse {
  private List<YoutubeVideo> items;
}
