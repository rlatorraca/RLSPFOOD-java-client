package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.client;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.ClientJavaApiException;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.RestaurantClient;
import org.springframework.web.client.RestTemplate;

public class RestaurantMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(
                    "http://api.rlspfood.local:8080",
                    restTemplate
            );

            restaurantClient
                    .listAll()
                    .stream()
                    .forEach(restaurant -> System.out.println(restaurant));
        } catch (ClientJavaApiException e) {
            if(e.getErrorModel() != null) {
                System.out.println(e.getErrorModel());
            } else {
                System.out.println("Unknown Error");
                e.printStackTrace();
            }
        }
    }
}
