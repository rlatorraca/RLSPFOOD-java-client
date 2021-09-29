package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.CityOutputModel;
import lombok.Data;

@Data
public class AddressInputModel {

    private String postalcode;

    private String street;

    private String number;

    private String complement;

    private String district;

    private CityInputModel city;
}
