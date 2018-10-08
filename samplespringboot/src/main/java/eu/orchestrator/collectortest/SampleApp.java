package eu.orchestrator.collectortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.logging.Logger;

/**
 * @author Panagiotis Gouvas
 */

@SpringBootApplication
@EnableScheduling
public class SampleApp {

  private static final Logger logger = Logger.getLogger(SampleApp.class.getName());

  public static void main(String[] args) {
    SpringApplication.run(SampleApp.class, args);

  }//EoM

}//EoC
