package br.com.cea.admission.service.impl;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import br.com.cea.admission.service.AdmiDigitalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmiDigitalServiceImpl implements AdmiDigitalService {

    private static final Logger logger = LogManager.getLogger(AdmiDigitalServiceImpl.class);

    @Autowired
    private AdmiDigitalRepository repository;

    @Autowired
    private DoclyServiceImpl service;

    public List<RhAdmission> findByStatus(String status) throws Exception {
        try {
            return repository.findByStatus(status);
        } catch (Exception e) {
            logger.error("====> findByStatus: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public void updateStatus(RhAdmission rhAdmission, String status) throws Exception {
        try {
            rhAdmission.setStatus(status);
            repository.save(rhAdmission);
        } catch (Exception e) {
            logger.error("====> updateStatus: " + e.getMessage());
            System.exit(1);
        }
    }

}
