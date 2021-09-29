package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.client;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.ClientJavaApiException;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api.RestaurantClient;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input.CityInputModel;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input.ProvinceInputModel;
import org.springframework.web.client.RestTemplate;

public class PostRestaurantsMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(
                    "http://api.rlspfood.local:8080",
                    restTemplate
            );

            var province = new ProvinceInputModel();
            province.setId(1l);

            var city = new CityInputModel();
            city.setId(1l);
            city.setProvince(province);

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
