package org.masouras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
//@ComponentScan(
//        basePackages = "org.masouras",
//        excludeFilters = {
//                @ComponentScan.Filter(
//                        type = FilterType.REGEX,
//                        pattern = "org\\.masouras\\.model\\.mssql\\..*"
//                )
//        }
//)
public class PrintingDataProcessQueueRun {
    public static void main(String[] args) {
        SpringApplication.run(PrintingDataProcessQueueRun.class, args);
    }
}
