package com.api.youtube.videos.controller;

import com.api.youtube.videos.dto.playlist.Playlist;
import com.api.youtube.videos.dto.playlist.PlaylistResponse;
import com.api.youtube.videos.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlists")
public class PlaylistController {

  @Autowired
  private PlaylistService service;

  @GetMapping
  public Page<Playlist> getPlaylistsByBandName(@RequestParam(value = "id", required = true) final String id,
                                              @RequestParam(value = "page", required = false, defaultValue = "") final String page,
                                              @RequestParam(value = "size", required = false, defaultValue = "20") final Integer size) {
    PlaylistResponse response = service.getPlaylistsByBandName(id, page, size);
    return new Page<Playlist>( response.getPlaylists(), response.getNextPage(),
      response.getPrevPage(), size, response.getTotal());
  }

}
