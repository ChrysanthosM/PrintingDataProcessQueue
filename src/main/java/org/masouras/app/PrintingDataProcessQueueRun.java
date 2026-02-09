package org.masouras.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
@EnableScheduling
public class PrintingDataProcessQueueRun {
    public static void main(String[] args) {
        SpringApplication.run(PrintingDataProcessQueueRun.class, args);
    }
}
