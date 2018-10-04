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
        String metricid = collector.registerMetric("cpu.utilization", "title1", "%", "user", "context1", ChartType.LINE);
        String dimensionid = collector.registerDimensionToMetric(metricid, "2xx");
        
        collector.logMetric(metricid, dimensionid, 5);

//        for (int i = 0; i < 10; i++) {
//            MetricEmitter emitter = new MetricEmitter(""+i);
//            Thread t = new Thread(emitter);
//            t.start();
//        }//for        


    }//EoM
}//EoC
