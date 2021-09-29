package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model;

import lombok.Data;

@Data
public class CityShortModel {

    private String postalcode;

    private String street;

    private String number;

    private String complement;

    private String district;

    private CityShortModel city;
}
