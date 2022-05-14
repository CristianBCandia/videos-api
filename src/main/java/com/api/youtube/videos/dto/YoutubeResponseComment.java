package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeResponseComment {
  private YoutubeCommentSnippet snippet;
  private String textOriginal;
  private String textDisplay;
}
