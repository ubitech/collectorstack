package eu.orchestrator.sample;

import eu.orchestrator.collector.ChartType;
import eu.orchestrator.collector.Collector;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class SampleNativeApp {  

    public static Collector collector = Collector.getInstance();

    private static final Logger logger = Logger.getLogger(SampleNativeApp.class.getName());

    public static void main(String[] args) throws InterruptedException {

        //collector.logMetric("kostas", "aaa");
        String metricid = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.stacked);
        String metricid2 = collector.registerMetric("ram.utilization", "title1", "%", "user", "context1", ChartType.stacked);
        String dimensionid11 = collector.registerDimensionToMetric(metricid, "1xx");
        String dimensionid12 = collector.registerDimensionToMetric(metricid, "11x");
        String dimensionid2 = collector.registerDimensionToMetric(metricid2, "2xx");
//        collector.removeDimensionFromMetric(metricid, dimensionid2);
        logger.info(collector.getMetric(metricid).toString());

        collector.logMetric(dimensionid11, 5);
        collector.logMetric(dimensionid11, 6);
        collector.logMetric(dimensionid12, 7);
        
//        collector.logMetric(dimensionid, 6);
        collector.logMetric(dimensionid2, 13);

//        for (int i = 0; i < 10; i++) {
//            MetricEmitter emitter = new MetricEmitter(""+i);
//            Thread t = new Thread(emitter);
//            t.start();
//        }//for        
    }//EoM
}//EoC
