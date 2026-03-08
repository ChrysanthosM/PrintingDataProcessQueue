package org.masouras.app.artemis.business.printing.consumer;

import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.data.boundary.PrintingDataEntityProcessor;

interface ConsumerBase {
    void handleMsgMain(PrintingDataEntityProcessor printingDataEntityProcessor, PrintingJobMessage msg);
}
