package com.api.youtube.videos.dto.youtube;

import com.api.youtube.videos.dto.video.VideoId;
import com.api.youtube.videos.dto.video.VideoSnippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeVideo {

  private VideoId id;
  private VideoSnippet snippet;

}
