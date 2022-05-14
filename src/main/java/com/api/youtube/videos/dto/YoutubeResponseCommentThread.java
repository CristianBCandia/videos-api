package com.api.youtube.videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeResponseCommentThread extends YoutubeResponse {
  private List<CommentThread> items;
}
