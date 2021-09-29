package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.AddressOutputModel;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.CuisineOutputModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantinputModel {


    private String name;

    private BigDecimal deliveryFee;

    private CuisineinputModel cuisine;

    private AddressInputModel address;

    private Boolean active;

    private Boolean opened;

    /*
    private OffsetDateTime createdDate;

    private OffsetDateTime dateLastUpdate;

    */
}
