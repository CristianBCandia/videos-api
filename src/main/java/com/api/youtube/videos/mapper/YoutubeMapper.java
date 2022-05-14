package com.api.youtube.videos.mapper;

import com.api.youtube.videos.dto.PageInfo;
import com.api.youtube.videos.dto.YoutubeVideo;
import com.api.youtube.videos.dto.YoutubeVideosResponse;
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

  public YoutubeVideosResponse toVideoResponse(HashMap youtube) {
    YoutubeVideosResponse videosResponse = new YoutubeVideosResponse();
    videosResponse.setPageInfo(this.getPageInfo((LinkedHashMap<String, Object>) youtube.get("pageInfo")
      != null ? (LinkedHashMap<String, Object>) youtube.get("pageInfo") : new LinkedHashMap<>()));
    videosResponse.setItems(this.getVideos((ArrayList) youtube.get("items")
      != null ? (ArrayList) youtube.get("items") : new ArrayList()));
    return videosResponse;
  }

  private PageInfo getPageInfo(LinkedHashMap<String, Object> pageInfo) {
    Integer totalResults = (Integer) pageInfo.get("totalResults");
    Integer resultsPerPage = (Integer) pageInfo.get("resultsPerPage");
    return new PageInfo(totalResults, resultsPerPage);
  }

  private List<YoutubeVideo> getVideos(ArrayList items) {
    return mapper.map(items, new TypeToken<List<YoutubeVideo>>() {}.getType());
  }

}
