package org.masouras.app.artemis.business.printing.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.boundary.PrintingDataEntityProcessor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediumPriorityConsumer extends AbstractConsumer {
    private final PrintingDataEntityProcessor printingDataEntityProcessor;
    private final JmsTemplate jmsTemplate;
    ;

    @Override
    @JmsListener(destination = "printingJobQueue", concurrency = "4-8")
    protected void handleMsg(PrintingJobMessage msg) {
        super.handleMsgMain(jmsTemplate, printingDataEntityProcessor, msg);
    }
}
