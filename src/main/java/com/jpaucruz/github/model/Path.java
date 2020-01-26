package com.jpaucruz.github.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Path {
  
  private String origin;
  private String destination;
  private double cost;
  
}