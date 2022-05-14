package com.api.youtube.videos.api;

import com.api.youtube.videos.dto.YoutubeVideosResponse;
import com.api.youtube.videos.mapper.YoutubeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Service
public class YoutubeApiService {

  @Value("${youtube.auth.key}")
  private String key;

  @Value("${youtube.url}")
  private String url;

  @Autowired
  private YoutubeMapper youtubeMapper;

  public YoutubeVideosResponse getVideosByBandName(String id) {
    RestTemplate template = new RestTemplate();
    String query = this.encodeValue(id);
    ResponseEntity<HashMap> response = template.getForEntity(URI.create(url + "part=snippet&q="+ query +"&key="+ key), HashMap.class);
    System.out.println(response.getBody());
    return youtubeMapper.toVideoResponse(response.getBody());
  }

  private String encodeValue(String value) {
    try {
      return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException(ex.getCause());
    }
  }

}
