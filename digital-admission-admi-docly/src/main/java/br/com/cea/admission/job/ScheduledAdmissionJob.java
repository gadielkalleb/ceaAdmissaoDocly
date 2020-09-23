package br.com.cea.admission.job;

import br.com.cea.admission.enums.StatusEnum;
import br.com.cea.admission.response.Authentication;
import br.com.cea.admission.response.Candidato;
import br.com.cea.admission.service.DoclyService;
import br.com.cea.admission.service.RhAdmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduledAdmissionJob {

    private static final Logger logger = LogManager.getLogger(ScheduledAdmissionJob.class);

    @Autowired
    private DoclyService doclyService;

    @Autowired
    private RhAdmissionService rhAdmissionService;

    public void execute(String dataInicio, String dataFim) {

        try {

            Optional<Authentication> authentication = Optional.ofNullable(doclyService.postAuthentication());

            authentication.flatMap(value -> doclyService.getPreAdmission(
                    StatusEnum.ADMITIDO.toString().toLowerCase(),
                    dataInicio,
                    dataFim,
                    value.getToken()
            )).ifPresent(candidatoes -> candidatoes.forEach(candidato -> {

                logger.info("====> id | cpf: " + candidato.get_id() + "|" + candidato.getCpf());

                //RH024T_ADMI_DIGITAL_RETORNO
                this.saveCandidato(candidato);

                //RH024T_ADMI_DIGITAL
                this.updateCandidato(candidato);
            }));

            logger.info("====> execute sucess ");
            System.exit(0);
        } catch (Exception e) {
            logger.error("====> execute error: " + e.getMessage());
            System.exit(1);
        }
    }

    private void updateCandidato(Candidato candidato) {
        try {
            rhAdmissionService.updateStatus(candidato);
        } catch (Exception e) {
            logger.error("====> updateCandidato - Exception: " + e.getMessage());
            System.exit(1);
        }
    }

    private void saveCandidato(Candidato candidato) {
        try {
            rhAdmissionService.saveCandidato(candidato);
        } catch (Exception e) {
            logger.error("====> saveCandidato - Exception: " + e.getMessage());
            System.exit(1);
        }
    }

}
