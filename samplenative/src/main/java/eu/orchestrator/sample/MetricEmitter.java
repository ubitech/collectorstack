package eu.orchestrator.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MetricEmitter implements Runnable {

    private static final Logger logger = Logger.getLogger(MetricEmitter.class.getName());
    private String name;
    public MetricEmitter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //SampleNativeApp.collector.logMetric("metric"+name, "10" + i);
            
            logger.info("Thread "+name+"added metric");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SampleNativeApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//for
    }//run
}//class
