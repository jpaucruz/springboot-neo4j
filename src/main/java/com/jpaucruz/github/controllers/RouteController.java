package com.jpaucruz.github.controllers;

import com.jpaucruz.github.model.Route;
import com.jpaucruz.github.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/routes")
public class RouteController {
  
  private RouteService routeService;
  
  @Autowired
  public RouteController(RouteService routeService) {
    this.routeService = routeService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<Route> searchForPaths(@RequestParam(value = "customer") String customer) {
    return routeService.searchRoutes(customer);
  }
  
}