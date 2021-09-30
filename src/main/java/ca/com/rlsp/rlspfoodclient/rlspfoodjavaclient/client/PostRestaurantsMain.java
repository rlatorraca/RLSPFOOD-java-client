package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.client;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.ClientJavaApiException;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.RestaurantClient;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input.*;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.RestaurantOutputModel;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class PostRestaurantsMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(
                    "http://api.rlspfood.local:8080",
                    restTemplate
            );


            var city = new CityInputModel();
            city.setId(1l);

            var cuisine = new CuisineinputModel();
            cuisine.setId(3L);

            var address = new AddressInputModel();
            address.setCity(new CityInputModel());
            address.setCity(city);
            address.setStreet("No name road, 1233");
            address.setComplement("apt 102");
            address.setDistrict("NortRiver");
            address.setPostalcode("A1B2C4");
            address.setNumber("8787");

            var restaurant = new RestaurantinputModel();
            restaurant.setCuisine(new CuisineinputModel());
            restaurant.setCuisine(cuisine);
            restaurant.setAddress(new AddressInputModel());
            restaurant.setAddress(address);
            restaurant.setName("RLSP New brazilian");
            restaurant.setDeliveryFee( new BigDecimal(10.5));

            var responseRestaurant = restaurantClient
                    .postRestaurant(restaurant);

            System.out.println(responseRestaurant);

        } catch (ClientJavaApiException e) {
            if(e.getErrorModel() != null) {
                System.out.println(e.getErrorModel().getUserMessage());
                e.getErrorModel()
                        .getErrorObjects()
                        .stream()
                        .forEach(p -> System.out.println("- " + p.getUserMessage()));
            } else {
                System.out.println("Unknown Error");
                e.printStackTrace();
            }
        }


    }
}
