package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantShortModel {

    private Long id;

    private String name;

    private BigDecimal deliveryFee;

    private CuisineShortModel  cuisine;

    private AddressShortModel address;

    private Boolean active;

    private Boolean opened;

    /*
    private OffsetDateTime createdDate;

    private OffsetDateTime dateLastUpdate;

    */
}
