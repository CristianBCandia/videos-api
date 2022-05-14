package com.api.youtube.videos.service;

import com.api.youtube.videos.dto.youtube.YoutubeVideosResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoServiceTest {

  @Value("${youtube.auth.key}")
  private String key;

  @Value("${youtube.url}")
  private String url;

  @Test
  public void consumeYoutubeApi() {
    RestTemplate template = new RestTemplate();
    template.getForEntity(URI.create(url + key), YoutubeVideosResponse.class);
  }
}
