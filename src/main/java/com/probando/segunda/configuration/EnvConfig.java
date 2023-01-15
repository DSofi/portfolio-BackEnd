
package com.probando.segunda.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "file:.env", ignoreResourceNotFound = true)
public class EnvConfig {
    
    @Autowired
    private Environment env;
        
    @Value("${DATASOURCE_URL}")
    String DATASOURCE_URL;
    
    @Value("${DATASOURCE_USERNAME}")
    String DATASOURCE_USERNAME;
    
    @Value("${DATASOURCE_PASSWORD}")
    String DATASOURCE_PASSWORD;
        
}
