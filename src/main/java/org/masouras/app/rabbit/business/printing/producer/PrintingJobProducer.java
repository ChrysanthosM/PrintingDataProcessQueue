package org.masouras.app.rabbit.business.printing.producer;

import lombok.RequiredArgsConstructor;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.business.printing.model.PrintJobMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrintingJobProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendHighPriority(PrintJobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.HIGH_QUEUE_ROUTING_KEY, msg);
    }

    public void sendMediumPriority(PrintJobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.MEDIUM_QUEUE_ROUTING_KEY, msg);
    }

    public void sendLowPriority(PrintJobMessage msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.LOW_QUEUE_ROUTING_KEY, msg);
    }
}
