package br.com.cea.admission.service.impl;

import br.com.cea.admission.entity.RhAdmissionArquivo;
import br.com.cea.admission.repository.AdmiDigitalArquivoRepository;
import br.com.cea.admission.request.Request;
import br.com.cea.admission.service.AdmiDigitalArquivoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmiDigitalArquivoServiceImpl implements AdmiDigitalArquivoService {

    private static final Logger logger = LogManager.getLogger(AdmiDigitalArquivoServiceImpl.class);

    @Autowired
    private AdmiDigitalArquivoRepository repository;

    public List<RhAdmissionArquivo> findByCpfAndStatus(String cpf, String status) {
        return repository.findByCpfAndStatus(cpf,status);
    }

    public void updateStatus(RhAdmissionArquivo arquivo, String status) {
        arquivo.setStatus(status);
        repository.save(arquivo);
    }
}
