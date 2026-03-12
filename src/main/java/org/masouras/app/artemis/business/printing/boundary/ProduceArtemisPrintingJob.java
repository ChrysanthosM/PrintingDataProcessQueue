package org.masouras.app.artemis.business.printing.boundary;

import org.masouras.app.artemis.business.printing.model.PrintingJobMessage;

public interface ProduceArtemisPrintingJob {
    void send(PrintingJobMessage printingJobMessage);
}
