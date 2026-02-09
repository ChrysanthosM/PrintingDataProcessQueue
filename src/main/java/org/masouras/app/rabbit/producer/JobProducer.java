package org.masouras.app.rabbit.producer;

import lombok.RequiredArgsConstructor;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.model.JobMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendHigh(JobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.HIGH_QUEUE_ROUTING_KEY, msg);
    }

    public void sendMedium(JobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.MEDIUM_QUEUE_ROUTING_KEY, msg);
    }

    public void sendLow(JobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.LOW_QUEUE_ROUTING_KEY, msg);
    }
}
