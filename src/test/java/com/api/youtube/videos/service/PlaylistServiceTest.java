package com.api.youtube.videos.service;

import com.api.youtube.videos.api.YoutubeApiService;
import com.api.youtube.videos.dto.playlist.PlaylistResponse;
import com.api.youtube.videos.dto.playlist.PlaylistSnippet;
import com.api.youtube.videos.dto.youtube.YoutubePageInfo;
import com.api.youtube.videos.dto.youtube.YoutubePlaylist;
import com.api.youtube.videos.dto.youtube.YoutubePlaylistResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PlaylistServiceTest {


  @MockBean
  private YoutubeApiService youtubeApiService;

  @Autowired
  private PlaylistService playlistService;

  @Test
  @DisplayName("Should return a object with a playlist of youtube videos and pagination info")
  public void getPlaylistByIdTest() throws Exception {

    List<YoutubePlaylist> youtubePlaylists = new ArrayList<>();
    youtubePlaylists.add(new YoutubePlaylist("123", new PlaylistSnippet("Eminem", "Eminem Oficial")));

    YoutubePlaylistResponse youtubePlaylistResponse = new YoutubePlaylistResponse();
    youtubePlaylistResponse.setItems(youtubePlaylists);
    youtubePlaylistResponse.setNextPageToken("2");
    youtubePlaylistResponse.setPrevPageToken("0");
    youtubePlaylistResponse.setPageInfo(new YoutubePageInfo(10, 5));

    Mockito.when(youtubeApiService.getPlaylistsById("1", "", 20))
      .thenReturn(youtubePlaylistResponse);

    PlaylistResponse response = playlistService.getPlaylistById("1", "", 20);

    Assertions.assertEquals(response.getTotal(), 10);
  }
}
