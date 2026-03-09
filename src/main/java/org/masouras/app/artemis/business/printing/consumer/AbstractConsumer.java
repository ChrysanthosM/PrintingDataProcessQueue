package org.masouras.app.artemis.business.printing.consumer;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.data.boundary.PrintingDataEntityProcessor;

@Slf4j
abstract class AbstractConsumer implements ConsumerBase {
    protected abstract void handleMsg(PrintingJobMessage msg);

    @Override
    public void handleMsgMain(PrintingDataEntityProcessor printingDataEntityProcessor, PrintingJobMessage msg) {
        Preconditions.checkNotNull(msg, "Message must not be null");

        printingDataEntityProcessor.processPrintingDataEntity(msg.getPrintingId());
        if (log.isInfoEnabled()) log.info("PrintingJobMessage processed: {}", msg.getPrintingId());
    }
}
