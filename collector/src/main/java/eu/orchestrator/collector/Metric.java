package eu.orchestrator.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Metric {

    private String metricname;
    private String title;
    private String unit;
    private String family;
    private String context;
    private ChartType charttype;               //line, area or stacked
    private Map<String, Dimension> dimensions;

    public Metric(String metricname, String title, String unit, String family, String context, ChartType charttype) {
        this.metricname = metricname;
        this.title = title;
        this.unit = unit;
        this.family = family;
        this.context = context;
        this.charttype = charttype;
        dimensions = new HashMap<>();
    }//EoC

    public void addDimension(Dimension dimension) {
        dimensions.put(dimension.getDimensionname(), dimension);
    }

    public void removeDimension(Dimension dimension) {
        dimensions.remove(dimension.getDimensionname());
    }

    public String getMetricname() {
        return metricname;
    }

    public void setMetricname(String metricname) {
        this.metricname = metricname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public ChartType getCharttype() {
        return charttype;
    }

    public void setCharttype(ChartType charttype) {
        this.charttype = charttype;
    }

    public Map<String, Dimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Map<String, Dimension> dimensions) {
        this.dimensions = dimensions;
    }


    @Override
    public String toString() {
        return "Metric{" + "metricname=" + metricname + ", title=" + title + ", unit=" + unit + ", family=" + family + ", context=" + context + ", charttype=" + charttype + ", dimensions=" + dimensions + '}';
    }

    
    
}//EoC
