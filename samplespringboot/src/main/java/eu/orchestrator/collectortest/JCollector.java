package eu.orchestrator.collectortest;

import eu.orchestrator.collector.Collector;
import org.springframework.stereotype.Component;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class JCollector extends Collector {

  public JCollector() {
    super(9999);
  }
}
