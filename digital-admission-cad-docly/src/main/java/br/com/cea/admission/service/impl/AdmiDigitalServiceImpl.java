package br.com.cea.admission.service.impl;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import br.com.cea.admission.vo.Authentication;
import br.com.cea.admission.service.AdmiDigitalService;
import br.com.cea.admission.vo.Colaborador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@Service
public class AdmiDigitalServiceImpl implements AdmiDigitalService {

    private static final Logger logger = LogManager.getLogger(AdmiDigitalServiceImpl.class);

    @Autowired
    private AdmiDigitalRepository repository;

    @Autowired
    private DoclyServiceImpl service;

    private String token = null;

    public List<RhAdmission> findByStatus(String status) {
        try {
            return repository.findByStatus(status);
        } catch (Exception e) {
            logger.error("====> findByStatus: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public String sendPreAdmission(List<Colaborador> colaboradores, String preAdmissaoId)  {
        try {
            Optional<Authentication> authentication = Optional.ofNullable(service.postAuthentication());
            authentication.ifPresent(a -> token = a.getToken());
            return service.postAdmission(colaboradores, preAdmissaoId, token);
        } catch (Exception e) {
            logger.error("====> sendPreAdmission: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public void updateStatusPreAdmissao(List<RhAdmission> rhAdmissions, Stream<String> idAdmissionStream, String status) {
        try {
            Map<String, String> map = combineListsIntoOrderedMap(rhAdmissions, idAdmissionStream);

            map.entrySet().stream()
                    .forEach(e -> {
                        repository.findById(Long.valueOf(e.getKey())).ifPresent(rhAdmission -> {
                            rhAdmission.setIdAdmissaoDocley(e.getValue());
                            rhAdmission.setStatus(status);
                            rhAdmission.setDataStatus(String.valueOf(LocalDateTime.now()));
                            repository.save(rhAdmission);
                        });
                    });
        } catch (Exception e) {
            logger.error("====> updateStatusPreAdmissao: " + e.getMessage());
            System.exit(1);
        }
    }

    private Map<String, String> combineListsIntoOrderedMap(List<RhAdmission> rhAdmissions, Stream<String> idAdmissionStream) {
        try {

            StringBuilder bldId = new StringBuilder();
            StringBuilder bldIdDocly = new StringBuilder();

            rhAdmissions.forEach(rhAdmission -> {
                bldId.append(rhAdmission.getId());
                bldId.append(" ");
            });

            idAdmissionStream.forEach(rhAdmission -> {
                bldIdDocly.append(rhAdmission.substring(35));
                bldIdDocly.append(" ");
            });

            List<String> convertedIdRhAdmissionList = Arrays.asList(bldId.toString().split(" "));

            List<String> convertedIdDoclyList = Arrays.asList(bldIdDocly.toString().split(" "));

            return combineListsIntoOrderedMap(convertedIdRhAdmissionList, convertedIdDoclyList);

        } catch (Exception e) {
            logger.error("====> combineListsIntoOrderedMap: " + e.getMessage());
            System.exit(1);
        }

        return null;
    }

    private Map<String,String> combineListsIntoOrderedMap (List<String> keys, List<String> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");
        Map<String,String> map = new LinkedHashMap<String,String>();
        for (int i=0; i<keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
