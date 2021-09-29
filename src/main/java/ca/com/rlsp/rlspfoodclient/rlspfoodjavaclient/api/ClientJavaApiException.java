package ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.api;

import ca.com.rlsp.rlspfoodclient.rlspfoodjavaclient.model.out.error.ErrorModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

@Slf4j
public class ClientJavaApiException extends RuntimeException {

    private static final String MSG_ERROR_WHEN_DOING_DESERIALIZATION = "Cannot deserialize the response into ClientJavaApiException.class";
    @Getter
    private ErrorModel errorModel;

    public ClientJavaApiException(String message, RestClientResponseException cause) {
        super(message, cause);

        deserializeError(cause);
    }

    private void deserializeError(RestClientResponseException cause)  {
        // Classe do Jackon que deserializa e serializa um JSON
        ObjectMapper mapper = new ObjectMapper();

        // Nao falha se atributo do Model estiverem faltando
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        /*
            Para poder deserializar OffsetDateTime (timestamp) - Se necessario
         */
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();

        try {
            this.errorModel = mapper.readValue(cause.getResponseBodyAsString(), ErrorModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.warn(MSG_ERROR_WHEN_DOING_DESERIALIZATION, e );
        }
    }
}
