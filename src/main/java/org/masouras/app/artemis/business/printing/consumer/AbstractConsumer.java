package org.masouras.app.artemis.business.printing.consumer;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;
import org.masouras.boundary.PrintingDataEntityProcessor;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingStatus;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
abstract class AbstractConsumer implements ConsumerBase {
    protected abstract void handleMsg(PrintingJobMessage msg);

    @Override
    public void handleMsgMain(JmsTemplate jmsTemplate, PrintingDataEntityProcessor printingDataEntityProcessor,
                              PrintingJobMessage msg) {
        Preconditions.checkNotNull(msg, "Message must not be null");

        PrintingDataEntity printingDataEntity = printingDataEntityProcessor.processPrintingDataEntity(msg.getPrintingId());
        if (printingDataEntity.getPrintingStatus() != PrintingStatus.PROCESSED) jmsTemplate.convertAndSend("printingJobQueue", msg);
        if (log.isInfoEnabled()) log.info("{}: HandleMsgMain printingDataEntity processed: {}, Status: {}", this.getClass().getSimpleName(), msg.getPrintingId(), printingDataEntity.getPrintingStatus());
    }
}
