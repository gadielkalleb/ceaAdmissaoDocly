package br.com.cea.admission.service;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.vo.Colaborador;

import java.util.List;
import java.util.stream.Stream;

public interface AdmiDigitalService {

    List<RhAdmission> findByStatus(String status);

    void updateStatusPreAdmissao(List<RhAdmission> rhAdmissions, Stream<String> idAdmissionStream, String status);

    String sendPreAdmission(List<Colaborador> colaboradores, String preAdmissaoId);
}
