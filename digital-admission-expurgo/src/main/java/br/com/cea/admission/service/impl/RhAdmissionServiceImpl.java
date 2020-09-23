package br.com.cea.admission.service.impl;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.entity.RhAdmissionHistorico;
import br.com.cea.admission.entity.RhAdmissionRetornoDocly;
import br.com.cea.admission.repository.AdmiDigitalHistoricoRepository;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import br.com.cea.admission.repository.AdmiDigitalRetornoRepository;
import br.com.cea.admission.service.RhAdmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RhAdmissionServiceImpl implements RhAdmissionService {

    private static final Logger logger = LogManager.getLogger(RhAdmissionServiceImpl.class);

    @Autowired
    private AdmiDigitalRetornoRepository admiDigitalRetornoRepository;

    @Autowired
    private AdmiDigitalRepository admiDigitalRepository;

    @Autowired
    private AdmiDigitalHistoricoRepository admiDigitalHistoricoRepository;

    @Override
    public List<RhAdmission> findByStatus(String status) {
        return admiDigitalRepository.findByStatus(status);
    }

    @Override
    public List<RhAdmissionRetornoDocly> findByCandidadto(String candidatoId) {
        return admiDigitalRetornoRepository.findByCandidatoId(candidatoId);
    }

    @Override
    public void exportToHistoric(RhAdmissionHistorico historico) {
        admiDigitalHistoricoRepository.save(historico);
    }

    @Override
    public void deletePreAdmissao(Long id) {
        admiDigitalRetornoRepository.deleteById(String.valueOf(id));
    }
}
