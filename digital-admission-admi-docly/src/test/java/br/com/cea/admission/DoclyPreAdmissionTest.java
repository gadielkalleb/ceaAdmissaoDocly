package br.com.cea.admission;

import br.com.cea.admission.request.Login;
import br.com.cea.admission.response.Authentication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DigitalAdmissionIntegrationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class DoclyPreAdmissionTest {

    private static final String DOCLY_CEA_EMAIL = "api-docly@homolog.com.br";
    private static final String DOCLY_CEA_SENHA = "CeA123@@";
    private static final String DOCLY_GET_ADMISSAO_STATUS = "cadastro";
    private static final String DOCLY_GET_ADMISSAO_INICIO = "1980-01-01T00:00:00.880Z";
    private static final String DOCLY_GET_ADMISSAO_FIM = "2020-12-31T00:00:00.880Z";
    private static final String BASE_URL_GET_ADMISSAO = "https://homo.docly.com.br/api/admissoes";
    private static final String BASE_URL_AUTHENTICATION = "https://homo.docly.com.br/api/login";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPreAdmission_200() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+this.obterTokenDocly());

        Map<String, String> params = new HashMap<>();
        params.put("status",  DOCLY_GET_ADMISSAO_STATUS);
        params.put("inicio",  DOCLY_GET_ADMISSAO_INICIO);
        params.put("fim",  DOCLY_GET_ADMISSAO_FIM);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL_GET_ADMISSAO);
        params.entrySet().stream().forEach(e -> uriBuilder.queryParam(e.getKey(),e.getValue()));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        System.out.println("====> uriBuilder: " + uriBuilder.build().toString());

        ResponseEntity<List> response = this.restTemplate.exchange(uriBuilder.build().toString(),
                                            HttpMethod.GET,
                                            entity,
                                            List.class,
                                            params);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetPreAdmission_401() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer xxx");

        Map<String, String> params = new HashMap<>();
        params.put("status",  DOCLY_GET_ADMISSAO_STATUS+"XX");
        params.put("inicio",  DOCLY_GET_ADMISSAO_INICIO);
        params.put("fim",  DOCLY_GET_ADMISSAO_FIM);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL_GET_ADMISSAO);
        params.entrySet().stream().forEach(e -> uriBuilder.queryParam(e.getKey(),e.getValue()));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        System.out.println("====> uriBuilder: " + uriBuilder.build().toString());

        ResponseEntity<String> response = this.restTemplate.exchange(uriBuilder.build().toString(),
                HttpMethod.GET,
                entity,
                String.class,
                params);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

        Assert.assertEquals("Unauthorized", response.getBody());
    }

    @Test
    public void testGetPreAdmission_403() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+this.obterTokenDocly());

        Map<String, String> params = new HashMap<>();
        params.put("status",  DOCLY_GET_ADMISSAO_STATUS+"XX");
        params.put("inicio",  DOCLY_GET_ADMISSAO_INICIO);
        params.put("fim",  DOCLY_GET_ADMISSAO_FIM);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL_GET_ADMISSAO);
        params.entrySet().stream().forEach(e -> uriBuilder.queryParam(e.getKey(),e.getValue()));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        System.out.println("====> uriBuilder: " + uriBuilder.build().toString());

        ResponseEntity<String> response = this.restTemplate.exchange(uriBuilder.build().toString(),
                HttpMethod.GET,
                entity,
                String.class,
                params);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());

        Assert.assertEquals("O status informado não existe!", response.getBody());

    }

    private String obterTokenDocly() throws Exception {

        Login login = new Login(DOCLY_CEA_EMAIL,DOCLY_CEA_SENHA);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Login> entity = new HttpEntity<>(login, headers);

        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<Authentication> response = restTemplate.exchange(
                                                BASE_URL_AUTHENTICATION,
                                                HttpMethod.POST,
                                                entity,
                                                Authentication.class);

        System.out.println("====> response token: " + response.getBody().getToken());

        return response.getBody().getToken();
    }

}
