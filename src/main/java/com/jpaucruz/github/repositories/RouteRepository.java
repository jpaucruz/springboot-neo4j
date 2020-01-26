package com.jpaucruz.github.repositories;

import com.jpaucruz.github.model.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository {
  
  List<Route> searchRoutes(String customer);
  
}
