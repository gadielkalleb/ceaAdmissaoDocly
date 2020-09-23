package br.com.cea.admission.service.impl;

import br.com.cea.admission.request.Login;
import br.com.cea.admission.request.Request;
import br.com.cea.admission.response.Authentication;
import br.com.cea.admission.service.DoclyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DoclyServiceImpl implements DoclyService {

    private static final Logger logger = LogManager.getLogger(DoclyServiceImpl.class);

    @Value("${docly.api.url}")
    private String docly;

    @Value("${docly.endpoint.authentication}")
    private String endpointAuthentication;

    @Value("${docly.endpoint.upload}")
    private String endpointUploadDoc;

    @Value("${docly.email.authentication}")
    private String email;

    @Value("${docly.senha.authentication}")
    private String senha;

    public Authentication postAuthentication() throws Exception {

        logger.info("====> postAuthentication: " + docly+endpointAuthentication);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Login> request = new HttpEntity<>(new Login(email,senha), headers);

        try {
            return restTemplate
                    .postForEntity(
                            docly+endpointAuthentication,
                            request,
                            Authentication.class)
                    .getBody();
        } catch (RestClientException e) {
            logger.error("====> postAuthentication - RestClientException: " + e.getMessage());
            System.exit(1);
        }

        return null;
    }

    public void postUploadDoc(Request req) throws Exception {

        logger.info("====> postUploadDoc: " + docly+endpointUploadDoc+req.getColaboradorId());

        try {
            Optional.ofNullable(postAuthentication()).ifPresent(authentication -> {

                List<String> listString = Arrays.asList(req.getImagem());
                req.setImagem(listString.toString());
                req.setClientId(authentication.getClienteId());

                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Authorization", "Bearer "+authentication.getToken());

                HttpEntity<Request> request = new HttpEntity<>(req, headers);

                ResponseEntity<String> response = restTemplate.exchange(
                        docly+endpointUploadDoc+req.getColaboradorId(),
                        HttpMethod.POST,
                        request,
                        String.class);

                logger.info("====> response postUploadDoc status: " + response.getStatusCodeValue());

            });
        } catch (Exception e) {
            logger.error("====> postUploadDoc: " + e.getMessage());
            System.exit(1);
        }

    }

}
