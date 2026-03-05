package org.masouras.app.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.model.JobMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LowPriorityConsumer {
    @RabbitListener(queues = RabbitConfig.LOW_QUEUE, concurrency = "1-4")
    public void handle(JobMessage msg) {
        if (log.isDebugEnabled()) log.debug("LOW job: {}", msg.getPayload());
    }
}
