package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.error;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorModel {

    private String status;
    private String userMessage;
    private OffsetDateTime dateTime;
    private List<WrongObject> errorObjects = new ArrayList<>();

    @Data
    public static class WrongObject {
        private String name;
        private String userMessage;
    }

}
