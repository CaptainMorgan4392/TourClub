package com.example.tourclub;

import com.example.tourclub.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@TestPropertySource(locations="classpath:application.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestConfig.class)
public class AbstractComponentTest {
    protected final String mail = "test_mail@mail.com";
    protected final String password = "hard_password12345678";
    private final List<String> dbList = List.of();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @LocalServerPort
    int port;

    RestTemplate restTemplate = new RestTemplate();

    protected <RequestType, ResponseType> ResponseType sendGetRequest(RequestType request, Class<ResponseType> responseClass, String path) {
        return sendRequest(request, responseClass, HttpMethod.GET, path);
    }

    protected <RequestType, ResponseType> ResponseType sendPutRequest(RequestType request, Class<ResponseType> responseClass, String path) {
        return sendRequest(request, responseClass, HttpMethod.PUT, path);
    }

    protected <RequestType, ResponseType> ResponseType sendDeleteRequest(RequestType request, Class<ResponseType> responseClass, String path) {
        return sendRequest(request, responseClass, HttpMethod.DELETE, path);
    }

    protected <RequestType, ResponseType> ResponseType sendPostRequest(RequestType request, Class<ResponseType> responseClass, String path) {
        return sendRequest(request, responseClass, HttpMethod.POST, path);
    }

    protected <RequestType, ResponseType> ResponseType sendRequest(RequestType request, Class<ResponseType> responseClass, HttpMethod httpMethod, String path) {
        HttpHeaders header = new HttpHeaders();
        return sendRequest(request, responseClass, httpMethod, path, header);
    }

    private <RequestType, ResponseType> ResponseType sendRequest(RequestType request, Class<ResponseType> responseClass, HttpMethod httpMethod, String path, HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ResponseType> entity;
        try {
            entity = restTemplate.exchange("http://localhost:" + port + path, httpMethod, new HttpEntity<>(request, headers), responseClass);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return entity.getBody();
    }
}
