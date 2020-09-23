package br.com.cea.admission.service;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.entity.RhAdmissionHistorico;
import br.com.cea.admission.entity.RhAdmissionRetornoDocly;

import java.util.List;

public interface RhAdmissionService {
    List<RhAdmission> findByStatus(String status);
    List<RhAdmissionRetornoDocly> findByCandidadto(String candidatoId);
    void exportToHistoric(RhAdmissionHistorico historico);
    void deletePreAdmissao(Long id);
}
