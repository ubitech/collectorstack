package eu.orchestrator.collector;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Collector {

    private static final Logger logger = Logger.getLogger(Collector.class.getName());

    // static variable single_instance of type Singleton 
    private static Collector collector_instance = null;
    private static int defaultport = 9090;
    
    private BlockingQueue<Measurement>  mqueue = new LinkedBlockingQueue<>();
    private ReportingServer rserver;
    
    public Collector(int port) {
        this.defaultport = port;
        rserver = new ReportingServer(port,mqueue);
        Thread rthread = new Thread(rserver);
        rthread.setPriority(Thread.MIN_PRIORITY);
        rthread.start();
    }//EoC

    // static method to create instance of Singleton class 
    public static Collector getInstance() {
        if (collector_instance == null) {
            collector_instance = new Collector(defaultport);
        }
        return collector_instance;
    }//EoM    
    public static Collector getInstance(int port) {
        if (collector_instance == null) {
            collector_instance = new Collector(port);
        }
        return collector_instance;
    }//EoM

    public void logMetric(String metricname,String value) {
        mqueue.add(new Measurement(metricname, value));
    }//EoM

}//EoC
