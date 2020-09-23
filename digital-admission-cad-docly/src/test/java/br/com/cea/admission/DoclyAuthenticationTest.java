package br.com.cea.admission;

import br.com.cea.admission.vo.Authentication;
import br.com.cea.admission.vo.Login;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("homo")
public class DoclyAuthenticationTest {

    private static final String DOCLY_CEA_EMAIL = "rh@cea.com.br";
    private static final String DOCLY_CEA_SENHA = "123456";
    private static final String baseUrlAuthentication = "https://app.docly.com.br/api/login";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void postAuthenticationDocly_Email_400() throws Exception {

        URI uri = new URI(baseUrlAuthentication);

        Login login = new Login("rh@cea.com",DOCLY_CEA_SENHA);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Login> request = new HttpEntity<>(login, headers);

        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        Assert.assertEquals(400, response.getStatusCodeValue());

        Assert.assertEquals(true, response.getBody().contains("Usuário não encontrado!"));
    }

    @Test
    public void postAuthenticationDocly_User_400() throws Exception {

        URI uri = new URI(baseUrlAuthentication);

        Login login = new Login(DOCLY_CEA_EMAIL,DOCLY_CEA_SENHA+"1");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Login> request = new HttpEntity<>(login, headers);

        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        Assert.assertEquals(400, response.getStatusCodeValue());

        Assert.assertEquals(true, response.getBody().contains("Senha incorreta!"));
    }

    @Test
    public void postAuthenticationDocly_200() throws URISyntaxException {

        URI uri = new URI(baseUrlAuthentication);

        Login login = new Login(DOCLY_CEA_EMAIL,DOCLY_CEA_SENHA);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Login> request = new HttpEntity<>(login, headers);

        ResponseEntity<Authentication> response = this.restTemplate.postForEntity(uri, request, Authentication.class);

        System.out.println("====> response 200 token: " + response.getBody().getToken());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Assert.assertEquals(200, response.getStatusCodeValue());
    }

}
