package com.mycloud.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.mycloud.platform")
@EntityScan(basePackages = "com.mycloud.platform.entity")
@EnableJpaRepositories(basePackages = "com.mycloud.platform.repository")
@EnableJpaAuditing
public class MyCloudPlatformApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MyCloudPlatformApplication.class, args);
    }
}
