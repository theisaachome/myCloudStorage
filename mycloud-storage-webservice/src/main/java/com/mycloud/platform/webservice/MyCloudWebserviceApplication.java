package com.mycloud.platform.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyCloudWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudWebserviceApplication.class, args);
    }

}
