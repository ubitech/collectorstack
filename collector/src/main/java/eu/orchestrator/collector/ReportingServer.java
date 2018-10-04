package eu.orchestrator.collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class ReportingServer implements Runnable {

    private static final Logger logger = Logger.getLogger(ReportingServer.class.getName());

    private int port = 9090;
    private BlockingQueue<Measurement> mqueue;

    public ReportingServer(int port, BlockingQueue<Measurement> mqueue) {
        this.port = port;
        this.mqueue = mqueue;
    }//EoC    

    @Override
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(port);
            try {
                while (true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        String reportingstr ="";
                        //logger.info("Queue size" + mqueue.size());
                        while (!mqueue.isEmpty()) {
                            Measurement m = mqueue.take();
                            //logger.info("De-Queueing " + m);
                            reportingstr+=m.toString() + " ";
                        }//Dequeue
                        out.println(reportingstr);
                        reportingstr = "";
                    } catch (InterruptedException ex) {
                        logger.log(Level.SEVERE, null, ex);
                    } finally {
                        socket.close();
                    }
                }
            } finally {
                listener.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }//run

}//EoC
