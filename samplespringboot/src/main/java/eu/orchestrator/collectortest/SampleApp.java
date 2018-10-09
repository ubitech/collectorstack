package eu.orchestrator.collectortest;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Panagiotis Gouvas
 */
@EnableScheduling
@SpringBootApplication
public class SampleApp {

  private static final Logger logger = Logger.getLogger(SampleApp.class.getName());

  public static void main(String[] args) {
    SpringApplication.run(SampleApp.class, args);

  }//EoM

}//EoC
