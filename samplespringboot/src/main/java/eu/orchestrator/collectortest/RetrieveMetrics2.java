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
public class RetrieveMetrics2 {

  private static final Logger logger = Logger.getLogger(RetrieveMetrics2.class.getName());

  @Autowired
  private final JCollector jCollector;

  private String trancodeRateIdDimentionOne;
  private String trancodeRateId;

  public RetrieveMetrics2(JCollector jCollector) {
    this.jCollector = jCollector;
    this.trancodeRateId = this.jCollector.registerMetric("transcodeRate2", "avgTranscodeRate2", "time2", "user2", "context2", ChartType.stacked);
    this.trancodeRateIdDimentionOne = this.jCollector.registerDimensionToMetric(this.trancodeRateId, "one2");
  }

  @Scheduled(fixedRate = 10000)
  private void retrieveAndPushAllMetric() {
    logger.info("############ Metric 2 ############");
    this.jCollector.logMetric(trancodeRateIdDimentionOne, 23);
  }
}
