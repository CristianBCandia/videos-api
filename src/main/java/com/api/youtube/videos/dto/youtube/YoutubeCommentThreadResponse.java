package com.api.youtube.videos.dto.youtube;

import com.api.youtube.videos.dto.comment.CommentThread;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YoutubeCommentThreadResponse extends YoutubeResponse {
  private List<CommentThread> items;
}
