package eu.orchestrator.collector;

/**
 *
 * @author Panagiotis Gouvas
 */
public enum AlgorithmType {
    ABSOLUTE,               //absolute, incremental, percentage-of-absolute-row or percentage-of-incremental-row    
    INCREMENTAL,
    PERCENTAGEOFABSOLUTEROW,
    PERCENTAGEOFINCREMENTALROW;
}
