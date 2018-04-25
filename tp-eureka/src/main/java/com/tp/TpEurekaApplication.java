package com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TP
 */
@EnableEurekaServer
@SpringBootApplication
public class TpEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpEurekaApplication.class, args);
	}
}
