package org.masouras.app.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.model.JobMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MediumPriorityConsumer {
    @RabbitListener(queues = RabbitConfig.MEDIUM_QUEUE, concurrency = "4-8")
    public void handle(JobMessage msg) {
        if (log.isDebugEnabled()) log.debug("MEDIUM job: {}", msg.getPayload());
    }
}
