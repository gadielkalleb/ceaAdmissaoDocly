package br.com.cea.admission.service.impl;

import br.com.cea.admission.request.Login;
import br.com.cea.admission.response.Authentication;
import br.com.cea.admission.response.Candidato;
import br.com.cea.admission.service.DoclyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoclyServiceImpl implements DoclyService {

    private static final Logger logger = LogManager.getLogger(DoclyServiceImpl.class);

    @Value("${docly.api.url}")
    private String docly;

    @Value("${docly.endpoint.authentication}")
    private String endpointAuthentication;

    @Value("${docly.endpoint.admissao}")
    private String endpointListaAdmissao;

    @Value("${docly.email.authentication}")
    private String email;

    @Value("${docly.senha.authentication}")
    private String senha;

    public Authentication postAuthentication()  {

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

    public Optional<List<Candidato>> getPreAdmission(String status, String inicio, String fim, String token) {

        logger.info("====> getPreAdmission: " + docly+endpointListaAdmissao);
        logger.info("====> token: " + token);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        Map<String, String> params = new HashMap<>();
        params.put("status",  status);
        params.put("inicio",  inicio);
        params.put("fim",  fim);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(docly+endpointListaAdmissao);

        params.entrySet().stream().forEach(e -> uriBuilder.queryParam(e.getKey(),e.getValue()));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(
                        uriBuilder.build().toString(),
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<Optional<List<Candidato>>>(){}
                    ).getBody();
        } catch (RestClientException e) {
            logger.error("====> postAuthentication - RestClientException: " + e.getMessage());
            System.exit(1);
        }

        return null;
    }

}
