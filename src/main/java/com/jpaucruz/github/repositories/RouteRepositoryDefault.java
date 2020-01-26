package com.jpaucruz.github.repositories;

import com.jpaucruz.github.components.RouteComponent;
import com.jpaucruz.github.model.Route;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteRepositoryDefault implements RouteRepository {
  
  private RouteComponent routeComponent;
  private Driver neo4jDriver;
  
  @Autowired
  public RouteRepositoryDefault(Driver neo4jDriver, RouteComponent routeComponent) {
    this.neo4jDriver = neo4jDriver;
    this.routeComponent = routeComponent;
  }
  
  @Override
  public List<Route> searchRoutes(String customer) {

    String query = "MATCH p=(f:factory)-[:SEND*]->(c:customer {id:\"" + customer + "\"})\n" +
    "WITH *, relationships(p) AS paths, reduce(cost=0, path in relationships(p) | cost+path.cost) AS total\n" +
    "RETURN f AS factory, paths, c AS customer, total\n" +
    "ORDER BY total ASC";
    
    return neo4jDriver
      .session()
      .run(query)
      .list(r -> routeComponent.mapNeo4JToRoute(r));
    
  }
  
}
