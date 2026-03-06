package org.masouras.app.rabbit.business.printing.consumer;

import org.masouras.app.rabbit.business.printing.model.PrintJobMessage;

sealed interface ConsumerBase permits LowPriorityConsumer, MediumPriorityConsumer, HighPriorityConsumer {
    void handlePrintJobMessage(PrintJobMessage msg);
}
