package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.input.RestaurantinputModel;
import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.RestaurantOutputModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RestaurantClient {


    public static final String RESOURCE_PATH = "/restaurants";
    private String url;

    // Classe do SpringBoot que ajuda fazer chamadas HTTP
    private RestTemplate restTemplate;

    public List<RestaurantOutputModel> listAll(){

        try{
            URI uriResource = URI.create(url + RESOURCE_PATH);

            // Faz o GET e retorna o objeto ja DESSERIALIZDO ( no tipo de retorno escolhido)
            RestaurantOutputModel[] restaurants = restTemplate
                    .getForObject(uriResource, RestaurantOutputModel[].class);

            return Arrays.asList(restaurants);

        } catch (RestClientResponseException e) {
            throw new ClientJavaApiException(e.getMessage(), e);
        }
    }

    public RestaurantOutputModel postRestaurant(RestaurantinputModel restaurantinputModel) {

        URI uriResource = URI.create(url + RESOURCE_PATH);
        try{
            // Faz o POST e retorna o objeto ja DESSERIALIZDO ( no tipo de retorno escolhido)
            return restTemplate
                    .postForObject(uriResource, restaurantinputModel, RestaurantOutputModel.class);

        } catch (RestClientResponseException e) {
            throw new ClientJavaApiException(e.getMessage(), e);
        }
    }

}
