package com.api.youtube.videos.service;

import com.api.youtube.videos.api.YoutubeApiService;
import com.api.youtube.videos.dto.Video;
import com.api.youtube.videos.dto.VideosResponse;
import com.api.youtube.videos.dto.YoutubeVideosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class VideoService {

  @Autowired
  private YoutubeApiService youtubeApiService;

  public VideosResponse getVideosByBandName(String bandName, Integer page, Integer size) {
    YoutubeVideosResponse youtubeResponse = youtubeApiService.getVideosByBandName(bandName);
    return new VideosResponse(
        youtubeResponse.getItems().stream()
        .map(video -> new Video(video.getId(), video.getSnippet().getTitle(), video.getSnippet().getDescription())).collect(Collectors.toList()),
        youtubeResponse.getPageInfo().getTotalResults());
  }
}
