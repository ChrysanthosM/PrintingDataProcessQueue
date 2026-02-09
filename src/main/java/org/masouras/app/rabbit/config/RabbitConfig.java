package org.masouras.app.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "jobs.exchange";

    public static final String HIGH_QUEUE = "jobs.high";
    public static final String HIGH_QUEUE_ROUTING_KEY = "job.high";
    public static final String MEDIUM_QUEUE = "jobs.medium";
    public static final String MEDIUM_QUEUE_ROUTING_KEY = "job.medium";
    public static final String LOW_QUEUE = "jobs.low";
    public static final String LOW_QUEUE_ROUTING_KEY = "job.low";

    @Bean
    DirectExchange jobsExchange() {
        return new DirectExchange(EXCHANGE);
    }


    @Bean
    Queue highQueue() {
        return QueueBuilder.durable(HIGH_QUEUE).build();
    }

    @Bean
    Queue mediumQueue() {
        return QueueBuilder.durable(MEDIUM_QUEUE).build();
    }

    @Bean
    Queue lowQueue() {
        return QueueBuilder.durable(LOW_QUEUE).build();
    }


    @Bean
    Binding bindHigh() {
        return BindingBuilder.bind(highQueue())
                .to(jobsExchange())
                .with(HIGH_QUEUE_ROUTING_KEY);
    }

    @Bean
    Binding bindMedium() {
        return BindingBuilder.bind(mediumQueue())
                .to(jobsExchange())
                .with(MEDIUM_QUEUE_ROUTING_KEY);
    }

    @Bean
    Binding bindLow() {
        return BindingBuilder.bind(lowQueue())
                .to(jobsExchange())
                .with(LOW_QUEUE_ROUTING_KEY);
    }
}
