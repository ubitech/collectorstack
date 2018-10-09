package eu.orchestrator.collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class ReportingServer implements Runnable {

    private static final Logger logger = Logger.getLogger(ReportingServer.class.getName());

    private int port = 9090;
    private Map<Metric, Map<Dimension, Integer>> mqueue;

    public ReportingServer(int port, Map<Metric, Map<Dimension, Integer>> mqueue) {
        this.port = port;
        this.mqueue = mqueue;
    }//EoC    

    private static String genMeasurement(Metric metric, Dimension dimension, int value) {
        String str = "\"" + metric.getMetricname() + "." + metric.getFamily() + "\": {"
                + "    \"options\": [\"" + metric.getMetricname() + "\", \"" + metric.getTitle() + "\", \"" + metric.getUnit() + "\", \"" + metric.getFamily() + "\", \"" + metric.getContext() + "\", \"" + metric.getCharttype() + "\"],"
                + "    \"lines\": ["
                + "      [\"" + metric.getMetricname() + "." + metric.getFamily() + "." + dimension.getDimensionname() + "\", \"" + dimension.getDimensionname() + "\", \"" + dimension.getAlgorithm() + "\", " + dimension.getMultiplier() + ", " + dimension.getDivisor() + ", " + value + " ]"
                + "    ]"
                + "  }";
        return str;
    }//EoM    

    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            try {
                while (true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        String reportingstr = "{";
                        //logger.info("Queue size" + mqueue.size());
                        int index = 0;
                        for (Map.Entry<Metric, Map<Dimension, Integer>> entry : mqueue.entrySet()) {
                            Metric metric = entry.getKey();
                            reportingstr += "\"" + metric.getMetricname() + "." + metric.getFamily() + "\": {"
                                    + "    \"options\": [\"" + metric.getMetricname() + "\", \"" + metric.getTitle() + "\", \"" + metric.getUnit() + "\", \"" + metric.getFamily() + "\", \"" + metric.getContext() + "\", \"" + metric.getCharttype() + "\"],"
                                    + "    \"lines\": [";
                            Map<Dimension, Integer> dimmap = entry.getValue();
                            int index2 = 0;
                            for (Map.Entry<Dimension, Integer> dimentry : dimmap.entrySet()) {
                                Dimension dimension = dimentry.getKey();
                                Integer value = dimentry.getValue();
                                reportingstr += "      [\"" + metric.getMetricname() + "." + metric.getFamily() + "." + dimension.getDimensionname() + "\", \"" + dimension.getDimensionname() + "\", \"" + dimension.getAlgorithm() + "\", " + dimension.getMultiplier() + ", " + dimension.getDivisor() + ", " + value + " ]";
                                index2++;
                                if (index2 < dimmap.entrySet().size()) {
                                    reportingstr += ",";
                                }
                            }//for
                            reportingstr += "    ]"
                                    + "  }";

                            index++;
                            if (index < mqueue.entrySet().size()) {
                                reportingstr += ",";
                            }
                        }//for

                        reportingstr += "}";

                        out.println(reportingstr);
                        reportingstr = "";
                    } catch (Exception ex) {
                        logger.log(Level.SEVERE, null, ex);
                    } finally {
                        socket.close();
                    }
                }//forever
            } finally {
                listener.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }//run

}//EoC
