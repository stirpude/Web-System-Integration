package com.iit.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 *
 * @author shruti
 * Class WorkoutApplication has the main method to run application
 * The Workout Application program is a Spring Boot Application that displays workout details
 */

@SpringBootApplication
public class WorkoutApplication {
	
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		SpringApplication.run(WorkoutApplication.class, args);
	}
}
