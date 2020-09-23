package br.com.cea.admission.service.impl;

import br.com.cea.admission.vo.Login;
import br.com.cea.admission.vo.Authentication;
import br.com.cea.admission.service.DoclyService;
import br.com.cea.admission.vo.Admissao;
import br.com.cea.admission.vo.Colaborador;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DoclyServiceImpl implements DoclyService {

    private static final Logger logger = LogManager.getLogger(DoclyServiceImpl.class);

    @Value("${docly.api.url}")
    private String docly;

    @Value("${docly.endpoint.authentication}")
    private String endpointAuthentication;

    @Value("${docly.endpoint.admissao}")
    private String endpointAdmissao;

    @Value("${docly.email.authentication}")
    private String email;

    @Value("${docly.senha.authentication}")
    private String senha;

    public Authentication postAuthentication() {

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

    public String postAdmission(List<Colaborador> colaboradores, String preAdmissaoId, String token) {

        logger.info("====> postAdmission: " + docly+endpointAdmissao);
        logger.info("====> token: " + token);

        Admissao admis = new Admissao();
        admis.setPreAdmissaoId(preAdmissaoId);
        admis.setColaboradores(colaboradores);

//        System.out.println(new Gson().toJson(admis));

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        HttpEntity<Admissao> request = new HttpEntity<>(admis, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(docly+endpointAdmissao, HttpMethod.POST, request, String.class);
            return response.getHeaders().getFirst("Location");
        } catch (Exception e) {
            logger.error("====> postAdmission - RestClientException: " + e.getMessage());
            System.exit(1);
        }

        return null;
    }

}
