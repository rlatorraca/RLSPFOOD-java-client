package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ErrorModel {

    private String status;
    private String userMessage;
    private OffsetDateTime dateTime;
}
