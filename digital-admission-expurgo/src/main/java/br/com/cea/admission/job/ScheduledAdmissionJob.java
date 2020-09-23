package br.com.cea.admission.job;

import br.com.cea.admission.entity.RhAdmissionHistorico;
import br.com.cea.admission.enums.StatusEnum;
import br.com.cea.admission.service.RhAdmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledAdmissionJob {

    private static final Logger logger = LogManager.getLogger(ScheduledAdmissionJob.class);

    @Autowired
    private RhAdmissionService rhAdmissionService;

    public void execute() {

        logger.info("====> Start process search status -> Admitido: " + LocalDateTime.now());

        rhAdmissionService.findByStatus(StatusEnum.ADMITIDO.toString()).forEach(rh -> {

            logger.info("====> candidato id: " + rh.getPreAdmissaoId());

            rhAdmissionService.findByCandidadto(rh.getPreAdmissaoId()).forEach(candidato -> {

                logger.info("====> candidato id | cpf: " + candidato.getCandidatoId() + " | " + candidato.getCpf());

                RhAdmissionHistorico rhAdmissionHistorico = new RhAdmissionHistorico();
                BeanUtils.copyProperties(candidato, rhAdmissionHistorico);

                rhAdmissionService.exportToHistoric(rhAdmissionHistorico);

                logger.info("====> cpf exportado: " + rhAdmissionHistorico.getCpf());

                rhAdmissionService.deletePreAdmissao(candidato.getId());

            });

        });

    }


}
