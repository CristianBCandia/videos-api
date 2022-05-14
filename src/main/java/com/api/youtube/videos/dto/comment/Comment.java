package com.api.youtube.videos.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  private String authorDisplayName;
  private String textDisplay;
}
