package com.tp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tp.admin", "com.tp.common.configer"})
@ServletComponentScan
public class TpUpmsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpUpmsServiceApplication.class, args);
	}
}
