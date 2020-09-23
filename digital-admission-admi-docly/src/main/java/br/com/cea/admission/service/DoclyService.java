package br.com.cea.admission.service;

import br.com.cea.admission.response.Authentication;
import br.com.cea.admission.response.Candidato;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface DoclyService {
    Authentication postAuthentication();
    Optional<List<Candidato>> getPreAdmission(String status, String inicio, String fim, String token);
}
