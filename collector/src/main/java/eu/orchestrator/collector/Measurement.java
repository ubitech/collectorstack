package eu.orchestrator.collector;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Measurement {

    private String metricname;
    private String value;

    public Measurement(String metricname, String value) {
        this.metricname = metricname;
        this.value = value;
    }    
    
    public String getMetricname() {
        return metricname;
    }

    public void setMetricname(String metricname) {
        this.metricname = metricname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }        

    @Override
    public String toString() {
        return "Measurement{" + "metricname=" + metricname + ", value=" + value + '}';
    }
    
    
    
}//EoM
