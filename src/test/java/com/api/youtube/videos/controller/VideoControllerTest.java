package com.api.youtube.videos.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import com.api.youtube.videos.dto.comment.Comment;
import com.api.youtube.videos.dto.comment.CommentResponse;
import com.api.youtube.videos.dto.video.Video;
import com.api.youtube.videos.dto.video.VideosResponse;
import com.api.youtube.videos.service.VideoService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
@ContextConfiguration(classes = VideoController.class)
public class VideoControllerTest {


  @MockBean
  private VideoService videoService;

  @Autowired
  private VideoController videoController;

  @BeforeEach
  public void init(){
    standaloneSetup(this.videoController);
  }

  @Test
  @DisplayName("Should return a list of youtube videos, fetched by band or artist name")
  public void getVideosByBandNameTest() throws Exception {

    List<Video> videoList = new ArrayList<>();
    videoList.add(Video.builder().title("My video").id("1").description("My description").build());
    Page<Video> videoPage = new Page<>();
    videoPage.setPrevPage("");
    videoPage.setNextPage("");
    videoPage.setSize(1);
    videoPage.setTotal(1);
    videoPage.setContent(videoList);

    VideosResponse videosResponse = VideosResponse.builder()
      .videos(videoList)
      .nextPage("")
      .prevPage("")
      .total(1)
      .build();

    when(this.videoService.getVideosByBandName("eminem", "", 20))
      .thenReturn(videosResponse);

    given()
      .queryParam("band_name", "eminem")
      .accept(ContentType.JSON)
      .when().get("/videos")
      .then()
      .body("content", hasItems(hasEntry("id", "1"), hasEntry("title", "My video"), hasEntry("description", "My description")))
      .body("size", is(20))
      .body("total", is(1))
      .statusCode(HttpStatus.OK.value());

  }

  @Test
  @DisplayName("Should return a page of comments from a video, fetched by video id")
  public void shoulReturnAPageOfComments() throws Exception {

    List<Comment> commentList = new ArrayList<>();
    commentList.add(Comment.builder().authorDisplayName("Cristian").textDisplay("My comment").build());
    Page<Comment> commentPage = new Page<>();
    commentPage.setPrevPage("");
    commentPage.setNextPage("");
    commentPage.setSize(1);
    commentPage.setTotal(1);
    commentPage.setContent(commentList);

    CommentResponse commentResponse = CommentResponse.builder()
      .comments(commentList)
      .nextPage("")
      .prevPage("")
      .total(1)
      .build();

    when(this.videoService.getCommentsByVideoId("123", "", 20))
      .thenReturn(commentResponse);

    given()
      .accept(ContentType.JSON)
      .when().get("/videos/{id}/comments", "123")
      .then()
      .body("content", hasItems(hasEntry("authorDisplayName", "Cristian"), hasEntry("textDisplay", "My comment")))
      .body("size", is(20))
      .body("total", is(1))
      .statusCode(HttpStatus.OK.value());

  }
}
