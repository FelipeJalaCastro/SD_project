package com.backendsd.backendsd;

import com.backendsd.backendsd.db.MongoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendSdApplication{

    public static void main(String[] args) {
        SpringApplication.run(BackendSdApplication.class, args);
    }

}
