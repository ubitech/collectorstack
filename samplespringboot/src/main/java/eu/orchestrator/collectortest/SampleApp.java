package eu.orchestrator.collectortest;

import eu.orchestrator.collector.ChartType;
import eu.orchestrator.collector.Collector;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Panagiotis Gouvas
 */

@SpringBootApplication
public class SampleApp {
    
    @Autowired
    Collector collector;
    
    private static final Logger logger = Logger.getLogger(SampleApp.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);
                
    }//EoM

    @PostConstruct
    public void init() {
        String metricid = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.LINE);
        String dimensionid = collector.registerDimensionToMetric(metricid, "2xx");
        String dimensionid2 = collector.registerDimensionToMetric(metricid, "3xx");
        collector.removeDimensionFromMetric(metricid, dimensionid2);
        logger.info(collector.getMetric(metricid).toString());

        collector.logMetric(metricid, dimensionid, 5);
        collector.logMetric(metricid, dimensionid, 6);        
    }//EoM    
    
}//EoC
