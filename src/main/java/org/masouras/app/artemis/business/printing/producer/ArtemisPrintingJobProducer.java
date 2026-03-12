package org.masouras.app.artemis.business.printing.producer;

import lombok.RequiredArgsConstructor;
import org.masouras.app.artemis.business.printing.boundary.ProduceArtemisPrintingJob;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ArtemisPrintingJobProducer implements ProduceArtemisPrintingJob {
    private final JmsTemplate jmsTemplate;

    @Override
    public void send(PrintingJobMessage printingJobMessage) {
        jmsTemplate.convertAndSend("printingJobQueue", printingJobMessage);
    }
}
