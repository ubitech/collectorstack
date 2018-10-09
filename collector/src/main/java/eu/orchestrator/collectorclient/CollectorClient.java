package eu.orchestrator.collectorclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Gouvas
 */
public class CollectorClient {
    
    private static final Logger logger = Logger.getLogger(CollectorClient.class.getName());
    
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 9999);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        logger.info("Collected:\n" + answer);
        System.exit(0);
    }
    
}//EoC
