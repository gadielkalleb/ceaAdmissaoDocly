package br.com.cea.admission.service;

import br.com.cea.admission.vo.Authentication;
import br.com.cea.admission.vo.Colaborador;

import java.util.List;

public interface DoclyService {
    Authentication postAuthentication();
    String postAdmission(List<Colaborador> colaboradores, String preAdmissaoId, String token);
}
