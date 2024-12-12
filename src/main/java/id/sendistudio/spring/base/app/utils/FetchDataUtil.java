package id.sendistudio.spring.base.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class FetchDataUtil {

    @Autowired
    private final RestTemplate restTemplate;

    /**
     * Method utama untuk melakukan request ke endpoint.
     * 
     * @param url          URL tujuan
     * @param method       HTTP Method (GET, POST, PUT, DELETE, etc.)
     * @param headers      Header request
     * @param body         Body request (null jika tidak diperlukan)
     * @param responseType Tipe data respons
     * @param <T>          Jenis respons yang diharapkan
     * @return ResponseEntity<T> berisi respons dari endpoint
     */
    public <T> ResponseEntity<T> request(String url, HttpMethod method, HttpHeaders headers, Object body,
            ParameterizedTypeReference<T> responseType) {
        try {
            // Pastikan headers tidak null
            if (headers == null) {
                headers = new HttpHeaders();
            }

            // Log request untuk debugging
            log.info("Sending {} request to URL: {}", method, url);

            // Buat HttpEntity dengan body dan headers
            HttpEntity<Object> entity = new HttpEntity<>(body, headers);

            // Kirim request dan kembalikan respons
            return restTemplate.exchange(url, method, entity, responseType);
        } catch (RestClientException ex) {
            // Tangani error dan log
            log.error("Error during REST call to URL: {}", url, ex);
            throw ex; // Rethrow jika ingin ditangani di tempat lain
        }
    }

    /**
     * Overload method untuk GET dengan body.
     */
    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, Object body,
            ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.GET, headers, body, responseType);
    }

    /**
     * Overload method untuk GET tanpa body.
     */
    public <T> ResponseEntity<T> get(String url, HttpHeaders headers, ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.GET, headers, null, responseType);
    }

    /**
     * Overload method untuk GET tanpa body dan headers.
     */
    public <T> ResponseEntity<T> get(String url, ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.GET, null, null, responseType);
    }

    /**
     * Overload method untuk POST.
     */
    public <T> ResponseEntity<T> post(String url, HttpHeaders headers, Object body,
            ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.POST, headers, body, responseType);
    }

    /**
     * Overload method untuk PUT.
     */
    public <T> ResponseEntity<T> put(String url, HttpHeaders headers, Object body,
            ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.PUT, headers, body, responseType);
    }

    /**
     * Overload method untuk DELETE.
     */
    public <T> ResponseEntity<T> delete(String url, HttpHeaders headers, ParameterizedTypeReference<T> responseType) {
        return request(url, HttpMethod.DELETE, headers, null, responseType);
    }
}
