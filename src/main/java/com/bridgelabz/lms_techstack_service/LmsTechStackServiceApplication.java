package com.bridgelabz.lms_techstack_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class LmsTechStackServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsTechStackServiceApplication.class, args);
    }

}
