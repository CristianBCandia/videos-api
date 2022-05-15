package com.api.youtube.videos.service;

import com.api.youtube.videos.api.YoutubeApiService;
import com.api.youtube.videos.dto.comment.Comment;
import com.api.youtube.videos.dto.comment.CommentResponse;
import com.api.youtube.videos.dto.comment.CommentSnippet;
import com.api.youtube.videos.dto.comment.CommentThread;
import com.api.youtube.videos.dto.video.VideoId;
import com.api.youtube.videos.dto.video.VideoSnippet;
import com.api.youtube.videos.dto.video.VideosResponse;
import com.api.youtube.videos.dto.youtube.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class VideoServiceTest {

  @MockBean
  private YoutubeApiService youtubeApiService;

  @Autowired
  private VideoService videoService;


  @Test
  @DisplayName("Should return a object with the videos and pagination info")
  public void getVideosByBandNameTest() throws Exception{

    YoutubeVideo youtubeVideo = YoutubeVideo.builder()
      .id(new VideoId("123"))
      .snippet(new VideoSnippet("My video", "My description"))
      .build();

    List<YoutubeVideo> items = new ArrayList<>();
    items.add(youtubeVideo);

    YoutubeVideosResponse youtubeVideosResponse = YoutubeVideosResponse.builder().items(items).build();
    youtubeVideosResponse.setPageInfo(new YoutubePageInfo(10, 5));
    youtubeVideosResponse.setNextPageToken("2");
    youtubeVideosResponse.setPrevPageToken("0");

    Mockito.when(this.youtubeApiService.getVideosByBandName("eminem", "", 20))
      .thenReturn(youtubeVideosResponse);

    VideosResponse response = videoService.getVideosByBandName("eminem", "", 20);

    Assertions.assertThat(response.getVideos() != null
      && response.getTotal() == 10
      && response.getVideos().get(0).getTitle() == "My video"
      && response.getVideos().get(0).getDescription() == "My description"
      && response.getVideos().get(0).getId() == "123"
      && response.getNextPage() == "2"
      && response.getPrevPage() == "0"
    );
  }

  @Test
  @DisplayName("Should return a object with the video comments and pagination info")
  public void getCommentsByVideoIdTest() throws Exception {

    List<CommentThread> commentThreadList = new ArrayList<>();
    commentThreadList.add(new CommentThread("1"));
    commentThreadList.add(new CommentThread("2"));
    commentThreadList.add(new CommentThread("3"));

    List<Comment> commentList = new ArrayList<>();
    commentList.add(new Comment("Cristian", "Eminem is great"));
    commentList.add(new Comment("Jhon", "Unlike for this video"));

    List<YoutubeComment> comments = new ArrayList<>();
    comments.add(new YoutubeComment("1", new CommentSnippet("Eminem is great", "Cristian")));
    comments.add(new YoutubeComment("2", new CommentSnippet("Unlike for this video", "Jhon")));


    YoutubeCommentThreadResponse youtubeCommentThreadResponse = YoutubeCommentThreadResponse.builder()
        .items(commentThreadList).build();
    youtubeCommentThreadResponse.setNextPageToken("2");
    youtubeCommentThreadResponse.setPrevPageToken("2");
    youtubeCommentThreadResponse.setPageInfo(new YoutubePageInfo(10, 5));

    YoutubeCommentsResponse youtubeCommentsResponse = YoutubeCommentsResponse.builder()
        .items(comments).build();
    youtubeCommentsResponse.setPageInfo(new YoutubePageInfo(10, 5));
    youtubeCommentsResponse.setNextPageToken("2");
    youtubeCommentsResponse.setPrevPageToken("0");


    Mockito.when(this.youtubeApiService.getThreadCommentsByVideoId("123", "", 20))
      .thenReturn(youtubeCommentThreadResponse);
    Mockito.when(this.youtubeApiService.getCommentsByIds(Arrays.asList("1", "2", "3")))
      .thenReturn(youtubeCommentsResponse);

    CommentResponse commentResponse = videoService.getCommentsByVideoId("123", "", 20);

    Assertions.assertThat(commentResponse.getComments() != null
      && commentResponse.getTotal() == 20
      && commentResponse.getComments().get(0).getTextDisplay() == "Eminem is great"
      && commentResponse.getComments().get(0).getAuthorDisplayName() == "Cristian"
      && commentResponse.getComments().get(1).getTextDisplay() == "Unlike for this video"
      && commentResponse.getComments().get(1).getAuthorDisplayName() == "Jhon"
      && commentResponse.getNextPage() == "2"
      && commentResponse.getPrevPage() == "0"
    );
  }
}
