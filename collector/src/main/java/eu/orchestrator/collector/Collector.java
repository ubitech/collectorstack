package eu.orchestrator.collector;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
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
    //synchronized
    private BlockingQueue<Measurement>  mqueue = new LinkedBlockingQueue<>();
    private ConcurrentHashMap<String,Metric> mmap = new ConcurrentHashMap<>();
    
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

    public void logMetric(String metricid,String dimensionid,int value) {
        Measurement measurement = new Measurement(metricid, dimensionid, value);
        mqueue.add(measurement);
    }//EoM

    public String registerMetric(String metricname, String title, String unit, String family, String context, ChartType charttype){        
        Metric metric = new Metric(metricname,  title,  unit,  family,  context, charttype);
        String midentifier = metricname+"."+family;
        if (!mmap.containsKey(midentifier)){
            mmap.put(midentifier, metric);
        }
        return midentifier;
    }//EoM
    
    public Metric getMetric(String metricname, String family){
        String midentifier = metricname+"."+family;
        return mmap.get(midentifier);
    }//EoM
    
    public void deleteMetric(Metric metric){
        String midentifier = metric.getMetricname()+"."+metric.getFamily();
        mmap.remove(midentifier);
    }//EoM
    
    public String registerDimensionToMetric(String midentifier, String dimensionname){
        Metric metric = mmap.get(midentifier);
        Dimension dim = new Dimension(dimensionname);
        if (!metric.getDimensions().contains(dim)) metric.getDimensions().add(dim);
        return midentifier+"."+dimensionname;
    }//EoM

    public void deleteDimensionFromMetric(String midentifier, String dimensionname){
        Metric metric = mmap.get(midentifier);
        Dimension dim = new Dimension(dimensionname);
        if (metric.getDimensions().contains(dim)) metric.getDimensions().remove(dim);
    }//EoM
    
    
}//EoC
