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
    private JCollector collector;
    
    private static final Logger logger = Logger.getLogger(SampleApp.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);
                
    }//EoM

    @PostConstruct
    public void init() {
   //     String metricid = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.stacked);
     //   String dimensionid = collector.registerDimensionToMetric(metricid, "2xx");
//        String dimensionid2 = collector.registerDimensionToMetric(metricid, "3xx");
//        collector.removeDimensionFromMetric(metricid, dimensionid2);
    //    logger.info(collector.getMetric(metricid).toString());

      //  collector.logMetric(dimensionid, 5.8);
//        collector.logMetric(dimensionid, 6);


        String metricId2 = collector.registerMetric("test","title2","","xxx","yyyy",ChartType.stacked);
        collector.logMetricWithDefaultDimension(metricId2,2.3);
        collector.logMetricWithDefaultDimension(metricId2,7.3);

     /*   String metricId2 = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.stacked);
        String dimensionid = collector.registerDimensionToMetric(metricId2, "dimentioId");
        collector.logMetric(dimensionid,2.3);
        collector.logMetric(dimensionid,7.3);
*/

    }//EoM
    
}//EoC
