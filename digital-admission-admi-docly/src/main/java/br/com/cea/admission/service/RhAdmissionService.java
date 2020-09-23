package br.com.cea.admission.service;

import br.com.cea.admission.response.Candidato;

public interface RhAdmissionService {

    void saveCandidato(Candidato candidato) throws Exception;
    void updateStatus(Candidato candidato) throws Exception;

}
