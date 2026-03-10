package org.masouras.app.artemis.business.printing.consumer;

import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.boundary.PrintingDataEntityProcessor;
import org.springframework.jms.core.JmsTemplate;

interface ConsumerBase {
    void handleMsgMain(JmsTemplate jmsTemplate, PrintingDataEntityProcessor printingDataEntityProcessor, PrintingJobMessage msg);
}
