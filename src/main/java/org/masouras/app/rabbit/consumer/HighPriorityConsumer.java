package org.masouras.app.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.model.JobMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HighPriorityConsumer {
    @RabbitListener(queues = RabbitConfig.HIGH_QUEUE, concurrency = "8-16")
    public void handle(JobMessage msg) {
        if (log.isDebugEnabled()) log.debug("HIGH job: {}", msg.getPayload());
    }
}
