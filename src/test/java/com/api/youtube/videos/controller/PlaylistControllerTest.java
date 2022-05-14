package com.api.youtube.videos.controller;

import com.api.youtube.videos.dto.playlist.Playlist;
import com.api.youtube.videos.dto.playlist.PlaylistResponse;
import com.api.youtube.videos.dto.video.Video;
import com.api.youtube.videos.dto.video.VideosResponse;
import com.api.youtube.videos.service.PlaylistService;
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

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest
@ContextConfiguration(classes = PlaylistController.class)
public class PlaylistControllerTest {


  @MockBean
  private PlaylistService playlistService;

  @Autowired
  private PlaylistController playlistController;

  @BeforeEach
  public void init(){
    standaloneSetup(this.playlistController);
  }

  @Test
  @DisplayName("Should return a page of an youtube playlist, fetched by playist id")
  public void getPlaylistsByIdTest() throws Exception {

    List<Playlist> playlistList = new ArrayList<>();
    playlistList.add(Playlist.builder().title("My playlist").channelTitle("My channel").id("123").build());
    Page<Playlist> playlistPage = new Page<>();
    playlistPage.setPrevPage("");
    playlistPage.setNextPage("");
    playlistPage.setSize(1);
    playlistPage.setTotal(1);
    playlistPage.setContent(playlistList);

    PlaylistResponse playlistResponse = PlaylistResponse.builder()
      .playlists(playlistList)
      .nextPage("")
      .prevPage("")
      .total(1)
      .build();

    when(this.playlistService.getPlaylistById("123", "", 20))
      .thenReturn(playlistResponse);

    given()
      .queryParam("id", "123")
      .accept(ContentType.JSON)
      .when().get("/playlists")
      .then()
      .body("content", hasItems(hasEntry("id", "123"), hasEntry("title", "My playlist"), hasEntry("channelTitle", "My channel")))
      .body("size", is(20))
      .body("total", is(1))
      .statusCode(HttpStatus.OK.value());

  }

}
