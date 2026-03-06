package org.masouras.app.rabbit.business.printing.consumer;

import lombok.extern.slf4j.Slf4j;
import org.masouras.app.rabbit.config.RabbitConfig;
import org.masouras.app.rabbit.business.printing.model.PrintJobMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public non-sealed class LowPriorityConsumer implements ConsumerBase {
    @RabbitListener(queues = RabbitConfig.LOW_QUEUE, concurrency = "1-4")
    public void handlePrintJobMessage(PrintJobMessage msg) {
        if (log.isDebugEnabled()) log.debug("LOW job: {}", msg.getPrintingId());
    }
}
