package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.RestaurantShortModel;
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

    public static final String RESOURCE_PATH = "/restaurantss";
    private String url;

    // Classe do SpringBoot que ajuda fazer chamadas HTTP
    private RestTemplate restTemplate;

    public List<RestaurantShortModel> listAll(){

        try{
            URI uriResource = URI.create(url + RESOURCE_PATH);

            // Faz o GET e retorna o objeto ja DESSERIALIZDO ( no tipo de retorno escolhido)
            RestaurantShortModel[] restaurants = restTemplate
                    .getForObject(uriResource, RestaurantShortModel[].class);

            return Arrays.asList(restaurants);

        } catch (RestClientResponseException e) {
            throw new ClientJavaApiException(e.getMessage(), e);
        }
    }

}
