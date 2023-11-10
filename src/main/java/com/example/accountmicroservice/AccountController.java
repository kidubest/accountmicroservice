package com.example.accountmicroservice;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public AccountController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountMicroserviceApp.class, args);
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return String.format("Hello from %s", eurekaClient.getApplication(appName).getName());
    }
}
