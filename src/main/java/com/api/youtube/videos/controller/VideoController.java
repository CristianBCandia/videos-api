package com.api.youtube.videos.controller;


import com.api.youtube.videos.dto.Video;
import com.api.youtube.videos.dto.VideosResponse;
import com.api.youtube.videos.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<Video> getVideosByBandName( @RequestParam(value = "band_name", required = true) final String bandName,
                                            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
                                            @RequestParam(value = "size", required = false, defaultValue = "20") final Integer size) {
      VideosResponse videoResponse = service.getVideosByBandName(bandName, page, size);
      return new Page<Video>(videoResponse.getVideos(), page, size, videoResponse.getTotal());
    }

}
