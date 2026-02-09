package org.masouras.app.rabbit.model;

import lombok.Data;

@Data
public class JobMessage {
    private String payload;
    private int priority;
}
