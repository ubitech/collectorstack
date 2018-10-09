package eu.orchestrator.collectortest;

import eu.orchestrator.collector.ChartType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Panagiotis Parthenis
 */
@Component
public class RetrieveMetrics {

  private static final Logger logger = Logger.getLogger(RetrieveMetrics.class.getName());

  @Autowired
  private final JCollector jCollector;

  private String trancodeRateIdDimentionOne;
  private String trancodeRateId;

  public RetrieveMetrics(JCollector jCollector) {
    this.jCollector = jCollector;
    this.trancodeRateId = this.jCollector.registerMetric("transcodeRate", "avgTranscodeRate", "time", "user", "context", ChartType.stacked);
    this.trancodeRateIdDimentionOne = this.jCollector.registerDimensionToMetric(this.trancodeRateId, "one");
  }

  @Scheduled(fixedRate = 10000)
  private void retrieveAndPushAllMetric() {
    logger.info("############ Metric 1 ############");
    this.jCollector.logMetric(trancodeRateIdDimentionOne, 2);
  }

}
