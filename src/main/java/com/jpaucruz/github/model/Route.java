package com.jpaucruz.github.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
  
  private String factory;
  private String customer;
  private List<Path> paths;
  private double cost;
  
}