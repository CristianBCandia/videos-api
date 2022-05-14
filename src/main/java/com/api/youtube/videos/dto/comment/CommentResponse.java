package com.api.youtube.videos.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponse {
  private List<Comment> comments;
  private Integer total;
  private String nextPage;
  private String prevPage;
}
