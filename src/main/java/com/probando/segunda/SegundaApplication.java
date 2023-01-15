package com.probando.segunda;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SegundaApplication {
    
    @Autowired
    private Environment env;      

    public static void main(String[] args) {
            SpringApplication.run(SegundaApplication.class, args);
    }  
    
        
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                            .allowedMethods("GET", "POST", "PUT", "DELETE")
                            .allowedOrigins("*")
                            .allowedHeaders("*");
            }
        };
    } 
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        String emailEmail = env.getProperty("EMAIL_EMAIL");
        String emailPassword = env.getProperty("EMAIL_PASSWORD");
    
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(emailEmail);
        mailSender.setPassword(emailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
