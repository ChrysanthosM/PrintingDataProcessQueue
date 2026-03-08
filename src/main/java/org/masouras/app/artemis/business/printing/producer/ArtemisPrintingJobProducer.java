package org.masouras.app.artemis.business.printing.producer;

import lombok.RequiredArgsConstructor;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtemisPrintingJobProducer {
    private final JmsTemplate jmsTemplate;

    public void send(PrintingJobMessage printingJobMessage) {
        jmsTemplate.convertAndSend("printingJobQueue", printingJobMessage);
    }
}
