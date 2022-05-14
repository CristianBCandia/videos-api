package com.api.youtube.videos.controller;


import com.api.youtube.videos.dto.*;
import com.api.youtube.videos.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    //TODO: Validar size em Max 50 Min 1
    public Page<Video> getVideosByBandName( @RequestParam(value = "band_name", required = true) final String bandName,
                                            @RequestParam(value = "page", required = false, defaultValue = "") final String page,
                                            @RequestParam(value = "size", required = false, defaultValue = "20") final Integer size) {
      VideosResponse response = service.getVideosByBandName(bandName, page, size);
      return new Page<Video>( response.getVideos(), response.getNextPage(),
                              response.getPrevPage(), size, response.getTotal());
    }

    @GetMapping("/{id}/comments")
    public Page<Comment> getCommentsById(@PathVariable("id") final String id,
                                         @RequestParam(value = "page", required = false, defaultValue = "") final String page,
                                         @RequestParam(value = "size", required = false, defaultValue = "20") final Integer size) {
      CommentResponse response = service.getCommeentsByVideoId(id, page, size);
      return new Page<Comment>( response.getComments(), response.getNextPage(),
        response.getPrevPage(), size, response.getTotal());
    }

}
