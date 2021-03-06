package eu.orchestrator.collector;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Collector {

    //private static final Logger logger = Logger.getLogger(Collector.class.getName());

    // static variable single_instance of type Singleton 
    private static Collector collector_instance = null;
    private static int defaultport = 9090;
    //synchronized

    private Map<String, Metric> mmap = new ConcurrentHashMap<>();

    private Map<Metric, Map<Dimension, Integer>> mqueue = new ConcurrentHashMap<>();

    private ReportingServer rserver;

    public Collector() {

        rserver = new ReportingServer(defaultport, mqueue);
        Thread rthread = new Thread(rserver);
        rthread.setPriority(Thread.MIN_PRIORITY);
        rthread.start();
    }//EoC    

    public Collector(int port) {
        this.defaultport = port;
        rserver = new ReportingServer(port, mqueue);
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

    public void logMetric(String dimensionid, int value) {
        int pivot = dimensionid.lastIndexOf(".");
        String metricid = dimensionid.substring(0, pivot);
        String dname = dimensionid.substring(pivot + 1, dimensionid.length());
        //logger.info("metric: " + metricid + " dim:" + dname);

        Metric metric = mmap.get(metricid);
        //logger.info(metric.toString());
        Dimension dim = metric.getDimensions().get(dname);

//        Measurement measurement = new Measurement(metricid, dimensionid, value);
        //measurement.setContent(genMeasurement(metric, dim, value));
        if (!mqueue.containsKey(metric)) {   //metric does not exist
            Map<Dimension, Integer> valuemap = new ConcurrentHashMap<>();
            valuemap.put(dim, value);
            mqueue.put(metric, valuemap);
        } else {//metric exists
            Map<Dimension, Integer> valuemap = mqueue.get(metric);
            valuemap.put(dim, value);   //always overwrite
            mqueue.put(metric, valuemap);
        }
//        logger.info(mqueue.toString());
    }//EoM



    public String registerMetric(String metricname, String title, String unit, String family, String context, ChartType charttype) {
        Metric metric = new Metric(metricname, title, unit, family, context, charttype);
        String midentifier = metricname + "." + family;
        if (!mmap.containsKey(midentifier)) {
            mmap.put(midentifier, metric);
        }
        return midentifier;
    }//EoM

    public Metric getMetric(String midentifier) {
        return mmap.get(midentifier);
    }//EoM

    public void removeMetric(Metric metric) {
        String midentifier = metric.getMetricname() + "." + metric.getFamily();
        mmap.remove(midentifier);
    }//EoM

    public String registerDimensionToMetric(String midentifier, String dimensionname) {
        Metric metric = mmap.get(midentifier);
        Dimension dim = new Dimension(dimensionname);
        metric.getDimensions().put(dimensionname, dim);
        String dimid = midentifier + "." + dimensionname;
        return dimid;
    }//EoM

    public void removeDimensionFromMetric(String midentifier, String dimid) {
        Metric metric = mmap.get(midentifier);
        metric.getDimensions().remove(dimid);
    }//EoM

}//EoC
