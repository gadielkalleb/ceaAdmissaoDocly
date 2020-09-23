package br.com.cea.admission.service;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.entity.RhAdmissionArquivo;

import java.util.List;

public interface AdmiDigitalService {

    List<RhAdmission> findByStatus(String status) throws Exception;
    void updateStatus(RhAdmission rhAdmission, String status) throws Exception;
}
