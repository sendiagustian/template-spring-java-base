package id.sendistudio.spring.base.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FetchDataUtil {

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    TypeUtil typeUtil;

    public <T> ResponseEntity<T> request(String url, HttpMethod method, HttpHeaders headers,
            ParameterizedTypeReference<T> responseType) {

        if (headers == null) {
            headers = new HttpHeaders();
        }

        String trx = typeUtil.genereateUUID();

        headers.set("LOG_SERVICE_TRX", trx);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, method, entity, responseType);
    }

    public <T> ResponseEntity<T> request(String url, HttpHeaders headers, ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.GET, headers, responseType);
    }

    public <T> ResponseEntity<T> request(String url, ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.GET, null, responseType);
    }

}