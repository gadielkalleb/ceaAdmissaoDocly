package br.com.cea.admission.job;

import br.com.cea.admission.enums.StatusEnum;
import br.com.cea.admission.response.Authentication;
import br.com.cea.admission.response.Candidato;
import br.com.cea.admission.service.DoclyService;
import br.com.cea.admission.service.RhAdmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ScheduledAdmissionCron {

    private static final Logger logger = LogManager.getLogger(ScheduledAdmissionCron.class);

    public static String dataInicio = null;
    public static String dataFim = null;

    @Autowired
    private DoclyService doclyService;

    @Autowired
    private RhAdmissionService rhAdmissionService;

    /*@Value("${admissoes.data.inicio.param}")
    private String dataInicio;

    @Value("${admissoes.data.fim.param}")
    private String dataFim;*/

    @Scheduled(cron = "${schedule.cron}")
    public void execute() {

        logger.info("====> Start process search status -> Admitido: " + LocalDateTime.now());

        Optional<Authentication> authentication = Optional.ofNullable(doclyService.postAuthentication());

        if(authentication.isPresent()){

            doclyService.getPreAdmission(
                    StatusEnum.ADMITIDO.toString().toLowerCase(),
                    dataInicio,
                    dataFim,
                    authentication.get().getToken()
            ).ifPresent(candidatoes -> {

                candidatoes.forEach(candidato -> {

                    logger.info("====> id | cpf: " + candidato.get_id() + "|" + candidato.getCpf());

                    //RH024T_ADMI_DIGITAL_RETORNO
                    this.saveCandidato(candidato);

                    //RH024T_ADMI_DIGITAL
                    this.updateCandidato(candidato);
                });
            });
        }
    }

    private void updateCandidato(Candidato candidato) {
        try {
            rhAdmissionService.updateStatus(candidato);
        } catch (Exception e) {
            logger.error("====> updateCandidato - Exception: " + e.getMessage());
        }
    }

    private void saveCandidato(Candidato candidato) {
        try {
            rhAdmissionService.saveCandidato(candidato);
        } catch (Exception e) {
            logger.error("====> saveCandidato - Exception: " + e.getMessage());
        }
    }

}
