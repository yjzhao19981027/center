package buaa.group6.litcenter;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Magauthor;
import buaa.group6.litcenter.service.AuthorService;
import buaa.group6.litcenter.service.LITService;
import buaa.group6.litcenter.util.tools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class LitcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LitcenterApplication.class, args);
    }

}
