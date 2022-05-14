package com.api.youtube.videos.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Page<T> {

  private List<T> content;
  private Integer page;
  private Integer size;
  private Integer total;

}
