package com.jpaucruz.github.services;

import com.jpaucruz.github.model.Route;

import java.util.List;

public interface RouteService {
  
  List<Route> searchRoutes(String customer);
  
}

