package org.masouras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PrintingDataProcessQueueRun {
    public static void main(String[] args) {
        SpringApplication.run(PrintingDataProcessQueueRun.class, args);
    }
}
