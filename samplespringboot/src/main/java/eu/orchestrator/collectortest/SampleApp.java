package eu.orchestrator.collectortest;

import eu.orchestrator.collector.ChartType;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author Panagiotis Gouvas
 */
@EnableScheduling
@SpringBootApplication
public class SampleApp {

    @Autowired
    JCollector collector;

    private static final Logger logger = Logger.getLogger(SampleApp.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);

    }//EoM

    @PostConstruct
    public void init() {

        String mymetric = collector.registerMetric("panos", "wwwwww", "pipestodeuterolepto", "oikogeneiapernomaste", "akoma to psaxnoume", ChartType.stacked);
        String dim1 = collector.registerDimensionToMetric(mymetric, "panos xamogelastos");
        String dim2 = collector.registerDimensionToMetric(mymetric, "panos thimomenos");
        String xroniapolla = collector.registerDimensionToMetric(mymetric, "xroniapolla");
        System.out.println("dim:"+xroniapolla);
        
        collector.logMetric(xroniapolla, 5);

//        String metricid = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.stacked);
//        String dimensionid = collector.registerDimensionToMetric(metricid, "2xx");
//        String dimensionid2 = collector.registerDimensionToMetric(metricid, "3xx");
//        collector.removeDimensionFromMetric(metricid, dimensionid2);
//        logger.info(collector.getMetric(metricid).toString());
//        collector.logMetric(dimensionid, 5);
//        collector.logMetric(dimensionid, 6);        
    }//EoM    

}//EoC
