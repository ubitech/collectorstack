package eu.orchestrator.collector;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Measurement {
    private String metricid;
    private String dimensionid;
    private int value;
    private long timestamp = System.currentTimeMillis();
 
    public Measurement(String metricid, String dimensionid, int value) {
        this.metricid = metricid;
        this.dimensionid = dimensionid;
        this.value = value;
    }

    public String getMetricid() {
        return metricid;
    }

    public void setMetricid(String metricid) {
        this.metricid = metricid;
    }

    public String getDimensionid() {
        return dimensionid;
    }

    public void setDimensionid(String dimensionid) {
        this.dimensionid = dimensionid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Measurement{" + "metricid=" + metricid + ", dimensionid=" + dimensionid + ", value=" + value + ", timestamp=" + timestamp + '}';
    }    
    
}//EoC
