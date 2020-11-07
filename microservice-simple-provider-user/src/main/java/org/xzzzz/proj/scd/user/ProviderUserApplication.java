package org.xzzzz.proj.scd.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

/**
 * @Author xzzzz
 * 2020/11/7
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }
}
