package eu.orchestrator.collector;

import java.util.Objects;

/**
 *
 * @author Panagiotis Gouvas
 */
public class Dimension {
    private String dimensionname;
    private AlgorithmType algorithm;       //absolute, incremental, percentage-of-absolute-row or percentage-of-incremental-row
    private int multiplier;
    private int divisor;

    public Dimension(String dimensionname) {
        this.dimensionname = dimensionname;
        this.algorithm = AlgorithmType.ABSOLUTE;
        this.multiplier = 1;
        this.divisor = 1;   
    }
    
    public Dimension(String dimensionname, AlgorithmType algorithm) {
        this.dimensionname = dimensionname;
        this.algorithm = algorithm;
        this.multiplier = 1;
        this.divisor = 1;
    }    

    public Dimension(String dimensionname, AlgorithmType algorithm, int multiplier, int divisor) {
        this.dimensionname = dimensionname;
        this.algorithm = algorithm;
        this.multiplier = multiplier;
        this.divisor = divisor;
    }    
    
    public String getDimensionname() {
        return dimensionname;
    }

    public void setDimensionname(String dimensionname) {
        this.dimensionname = dimensionname;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dimension other = (Dimension) obj;
        if (!Objects.equals(this.dimensionname, other.dimensionname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dimension{" + "dimensionname=" + dimensionname + ", algorithm=" + algorithm + ", multiplier=" + multiplier + ", divisor=" + divisor + '}';
    }    
    
}//EoC
