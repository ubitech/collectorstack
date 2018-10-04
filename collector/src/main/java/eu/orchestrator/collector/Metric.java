package eu.orchestrator.collector;

import java.util.ArrayList;
import java.util.List;

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
    private List<Dimension> dimensions;

    public Metric(String metricname, String title, String unit, String family, String context, ChartType charttype) {
        this.metricname = metricname;
        this.title = title;
        this.unit = unit;
        this.family = family;
        this.context = context;
        this.charttype = charttype;
        dimensions = new ArrayList<>();
    }//EoC

    public void addDimension(Dimension dimension) {
        if (!dimensions.contains(dimension)) {
            dimensions.add(dimension);
        }
    }

    public void removeDimension(Dimension dimension) {
        dimensions.remove(dimension);
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

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<Dimension> dimensions) {
        this.dimensions = dimensions;
    }

}//EoC
