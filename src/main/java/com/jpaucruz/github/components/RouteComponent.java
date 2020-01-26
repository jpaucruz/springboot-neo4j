package com.jpaucruz.github.components;

import com.jpaucruz.github.model.Path;
import com.jpaucruz.github.model.Route;
import org.assertj.core.util.Lists;
import org.neo4j.driver.Record;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteComponent {
  
  public Route mapNeo4JToRoute(Record record) {
    
    List<Path> paths = Lists.newArrayList();
    record.get("paths").values()
      .forEach(path ->
        paths.add(
          Path
            .builder()
            .origin(path.get("origin").asString())
            .destination(path.get("destination").asString())
            .cost(path.get("cost").asDouble())
            .build()
        )
      );
    
    return Route
      .builder()
      .factory((String) record.get("factory").asNode().asMap().get("name"))
      .customer((String) record.get("customer").asNode().asMap().get("name"))
      .paths(paths)
      .cost(record.get("total").asDouble())
      .build();
  }
  
}
