package br.com.cea.admission.service;

import br.com.cea.admission.entity.RhAdmissionArquivo;
import br.com.cea.admission.request.Request;

import java.util.List;

public interface AdmiDigitalArquivoService {

    List<RhAdmissionArquivo> findByCpfAndStatus(String cpf, String status);
    void updateStatus(RhAdmissionArquivo arquivo, String status);
}
