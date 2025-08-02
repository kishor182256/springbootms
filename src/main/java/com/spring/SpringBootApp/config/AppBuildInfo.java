package com.spring.SpringBootApp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "build")
@Data
public class AppBuildInfo {

    private String version;
    private String id;
    private String name;


}
