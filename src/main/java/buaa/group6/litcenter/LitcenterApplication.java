package buaa.group6.litcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LitcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LitcenterApplication.class, args);
    }

}
