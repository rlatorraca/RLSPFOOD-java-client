package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantOutputModel {

    private Long id;

    private String name;

    private BigDecimal deliveryFee;

    private CuisineOutputModel cuisine;

    private AddressOutputModel address;

    private Boolean active;

    private Boolean opened;

    /*
    private OffsetDateTime createdDate;

    private OffsetDateTime dateLastUpdate;

    */
}
