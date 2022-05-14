package com.api.youtube.videos.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

  private List<T> content;
  private String nextPage;
  private String prevPage;
  private Integer size;
  private Integer total;

}
