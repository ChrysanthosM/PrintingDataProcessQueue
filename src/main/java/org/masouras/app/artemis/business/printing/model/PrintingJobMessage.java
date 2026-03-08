package org.masouras.app.artemis.business.printing.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PrintingJobMessage implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    private final Long printingId;
}
