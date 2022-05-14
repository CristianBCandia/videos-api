package com.api.youtube.videos.dto.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeCommentResponse {
  private YoutubeCommentSnippet snippet;
  private String textOriginal;
  private String textDisplay;
}
