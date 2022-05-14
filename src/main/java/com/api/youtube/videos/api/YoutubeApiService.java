package com.api.youtube.videos.api;

import com.api.youtube.videos.dto.youtube.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YoutubeApiService {

  @Value("${youtube.auth.key}")
  private String key;

  @Value("${youtube.url}")
  private String url;

  @Autowired
  private RestTemplate template;

  public YoutubeVideosResponse getVideosByBandName(String bandName, String page, Integer size) {

    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("part", "snippet");
    queryParams.put("q", bandName);
    queryParams.put("maxResults", size.toString());
    if (!ObjectUtils.isEmpty(page)) {
      queryParams.put("pageToken", page);
    }
    return (YoutubeVideosResponse) getYoutube(queryParams, "search", YoutubeVideosResponse.class);
  }

  public YoutubeCommentThreadResponse getThreadCommeentsByVideoId(String videoId, String page, Integer size) {
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("videoId", videoId);
    queryParams.put("maxResults", size.toString());
    if (!ObjectUtils.isEmpty(page)) {
      queryParams.put("pageToken", page);
    }
    return (YoutubeCommentThreadResponse) getYoutube(queryParams, "commentThreads", YoutubeCommentThreadResponse.class);
  }

  public YoutubeCommentsResponse getCommeentsByIds(List<String> ids) {
    String query = String.join(",", ids);
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("part", "snippet");
    queryParams.put("id", query);
    return (YoutubeCommentsResponse) getYoutube(queryParams, "comments", YoutubeCommentsResponse.class);
  }

  private YoutubeResponse getYoutube(Map<String, String> queryParams, String path, Class responseType) {
    StringBuilder uri = new StringBuilder(url + "/" + path + "?key={key}");
    queryParams.keySet().forEach(key -> {
      uri.append("&").append(key).append("={").append(key).append("}");
    });
    Map<String, String> params = queryParams;
    params.put("key", this.key);

    ResponseEntity<YoutubeResponse> response = template.getForEntity(uri.toString(), responseType, params);
    return response.getBody();
  }

  public YoutubePlaylistResponse getPlaylistsById(String id, String page, Integer size) {
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("part", "snippet");
    queryParams.put("playlistId", id);
    queryParams.put("maxResults", size.toString());
    if (!ObjectUtils.isEmpty(page)) {
      queryParams.put("pageToken", page);
    }
    return (YoutubePlaylistResponse) getYoutube(queryParams, "playlistItems", YoutubePlaylistResponse.class);
  }
}
