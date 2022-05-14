package com.api.youtube.videos.dto.youtube;

import com.api.youtube.videos.dto.comment.CommentSnippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeComment {
  private String id;
  private CommentSnippet snippet;
}
