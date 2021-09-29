package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out;

import lombok.Data;

@Data
public class AddressOutputModel {

    private String postalcode;

    private String street;

    private String number;

    private String complement;

    private String district;

    private CityOutputModel city;
}
