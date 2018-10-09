
package eu.orchestrator.collectortest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author ubuntu
 */
@Component
public class Schedule1 {
    
    @Autowired
    JCollector collector;    
    
    @Scheduled(fixedRate = 5000)
    public void metramori() {
        collector.logMetric("panos.oikogeneiapernomaste.xroniapolla", 6);       
    }    
    
}
