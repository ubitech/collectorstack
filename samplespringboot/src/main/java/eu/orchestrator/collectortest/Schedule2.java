
package eu.orchestrator.collectortest;

import eu.orchestrator.collector.Dimension;
import eu.orchestrator.collector.Metric;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author ubuntu
 */
@Component
public class Schedule2 {

    private static final Logger LOG = Logger.getLogger(Schedule2.class.getName());
    
    @Autowired
    JCollector collector;    
    
    @Scheduled(fixedRate = 5000)
    public void metramori() {
        Metric metric = collector.getMetric("panos.oikogeneiapernomaste");
        Map<String, Dimension> dimensions = metric.getDimensions();
        LOG.info(dimensions.toString());
               
    }    
    
}
