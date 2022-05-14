package com.api.youtube.videos.mapper;

import com.api.youtube.videos.dto.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class YoutubeMapper {

  @Autowired
  private ModelMapper mapper;

  public YoutubeCommentsResponse toCommentResponse(HashMap youtube) {
    YoutubeCommentsResponse commentsResponse = new YoutubeCommentsResponse();
    commentsResponse.setItems(this.getCommentItems((ArrayList) youtube.get("items")
      != null ? (ArrayList) youtube.get("items") : new ArrayList()));
    return commentsResponse;
  }

  public YoutubeVideosResponse toVideoResponse(HashMap youtube) {
    YoutubeVideosResponse videosResponse = new YoutubeVideosResponse();
    videosResponse.setPageInfo(this.getPageInfo((LinkedHashMap<String, Object>) youtube.get("pageInfo")
      != null ? (LinkedHashMap<String, Object>) youtube.get("pageInfo") : new LinkedHashMap<>()));
    videosResponse.setItems(this.getVideoItems((ArrayList) youtube.get("items")
      != null ? (ArrayList) youtube.get("items") : new ArrayList()));
    return videosResponse;
  }

  private YoutubePageInfo getPageInfo(LinkedHashMap<String, Object> pageInfo) {
    Integer totalResults = (Integer) pageInfo.get("totalResults");
    Integer resultsPerPage = (Integer) pageInfo.get("resultsPerPage");
    return new YoutubePageInfo(totalResults, resultsPerPage);
  }

  private List<YoutubeVideo> getVideoItems(ArrayList items) {
    return mapper.map(items, new TypeToken<List<YoutubeVideo>>() {}.getType());
  }

  private List<YoutubeComment> getCommentItems(ArrayList items) {
    return mapper.map(items, new TypeToken<List<YoutubeVideo>>() {}.getType());
  }
}
