package com.api.youtube.videos.service;

import com.api.youtube.videos.api.YoutubeApiService;
import com.api.youtube.videos.dto.comment.Comment;
import com.api.youtube.videos.dto.comment.CommentResponse;
import com.api.youtube.videos.dto.comment.CommentThread;
import com.api.youtube.videos.dto.video.Video;
import com.api.youtube.videos.dto.video.VideosResponse;
import com.api.youtube.videos.dto.youtube.YoutubeCommentThreadResponse;
import com.api.youtube.videos.dto.youtube.YoutubeCommentsResponse;
import com.api.youtube.videos.dto.youtube.YoutubeVideosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VideoService {

  @Autowired
  private YoutubeApiService youtubeApiService;

  public VideosResponse getVideosByBandName(String bandName, String page, Integer size) {
    YoutubeVideosResponse youtubeResponse = youtubeApiService.getVideosByBandName(bandName, page, size);
    return new VideosResponse(
        youtubeResponse.getItems().stream()
        .map(video -> new Video(video.getId().getVideoId(), video.getSnippet().getTitle(), video.getSnippet().getDescription())).collect(Collectors.toList()),
        youtubeResponse.getPageInfo().getTotalResults(),
      youtubeResponse.getNextPageToken(),
      youtubeResponse.getPrevPageToken()
      );
  }


  public CommentResponse getCommentsByVideoId(String videoId, String page, Integer size) {
    YoutubeCommentThreadResponse youtubeResponse = youtubeApiService.getThreadCommeentsByVideoId(videoId, page, size);
    YoutubeCommentsResponse response = youtubeApiService.getCommeentsByIds(youtubeResponse.getItems().stream().map(CommentThread::getId).collect(Collectors.toList()));
    return new CommentResponse(response.getItems().stream()
      .map(item -> new Comment( item.getSnippet().getAuthorDisplayName(),
                                item.getSnippet().getTextDisplay()))
                                .collect(Collectors.toList()),
                                youtubeResponse.getPageInfo().getTotalResults(),
                                youtubeResponse.getNextPageToken(),
                                youtubeResponse.getPrevPageToken());
  }
}
