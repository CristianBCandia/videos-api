package com.api.youtube.videos.service;

import com.api.youtube.videos.api.YoutubeApiService;
import com.api.youtube.videos.dto.playlist.Playlist;
import com.api.youtube.videos.dto.playlist.PlaylistResponse;
import com.api.youtube.videos.dto.youtube.YoutubePlaylistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PlaylistService {

  @Autowired
  private YoutubeApiService youtubeApiService;


    public PlaylistResponse getPlaylistById(String id, String page, Integer size) {
        YoutubePlaylistResponse youtubeResponse = youtubeApiService.getPlaylistsById(id, page, size);
        return new PlaylistResponse(
          youtubeResponse.getItems().stream()
            .map(playlist -> new Playlist(playlist.getId(), playlist.getSnippet().getTitle(), playlist.getSnippet().getChannelTitle()))
            .collect(Collectors.toList()),
          youtubeResponse.getPageInfo().getTotalResults(),
          youtubeResponse.getNextPageToken(),
          youtubeResponse.getPrevPageToken()
        );
    }
}
