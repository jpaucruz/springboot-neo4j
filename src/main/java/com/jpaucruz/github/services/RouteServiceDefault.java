package com.jpaucruz.github.services;

import com.jpaucruz.github.model.Route;
import com.jpaucruz.github.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceDefault implements RouteService {
  
  private RouteRepository routeRepository;
  
  @Autowired
  public RouteServiceDefault(RouteRepository routeRepository) {
    this.routeRepository = routeRepository;
  }
  
  @Override
  public List<Route> searchRoutes(String customer) {
    return routeRepository.searchRoutes(customer);
  }
  
}
