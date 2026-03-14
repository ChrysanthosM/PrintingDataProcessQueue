package org.masouras.app.artemis.business.printing.consumer;

import lombok.extern.slf4j.Slf4j;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.boundary.PrintingDataEntityProcessor;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;

import java.util.Objects;

@Slf4j
abstract class AbstractConsumer implements ConsumerBase {
    protected abstract void handleMsg(PrintingJobMessage msg);

    @Override
    public void handleMsgMain(PrintingDataEntityProcessor printingDataEntityProcessor,
                              PrintingJobMessage msg) {
        Objects.requireNonNull(msg, "Message must not be null");

        PrintingDataEntity printingDataEntity = printingDataEntityProcessor.processPrintingDataEntity(msg.getPrintingId());


        if (log.isInfoEnabled()) log.info("{}: HandleMsgMain printingDataEntity processed: {}, Status: {}", this.getClass().getSimpleName(), msg.getPrintingId(), printingDataEntity.getPrintingStatus());
    }
}
