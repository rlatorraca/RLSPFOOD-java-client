package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.client;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.RestaurantClient;
import org.springframework.web.client.RestTemplate;

public class RestaurantMain {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        RestaurantClient restaurantClient = new RestaurantClient(
                "http://api.rlspfood.local:8080",
                restTemplate
        );

        restaurantClient
                .listAll()
                .stream()
                .forEach(restaurant -> System.out.println(restaurant));
    }
}
