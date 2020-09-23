package br.com.cea.admission.job;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.service.AdmiDigitalService;
import br.com.cea.admission.vo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class ScheduledAdmissionCron {

    private static final Logger logger = LogManager.getLogger(ScheduledAdmissionCron.class);

    @Autowired
    private AdmiDigitalService admiDigitalService;

    private String preAdmissaoId = null;

    Pattern pattern = Pattern.compile(",");

    @Scheduled(cron = "${schedule.cron}")
    public void execute() {

        logger.info("====> Start process digital admission: " + LocalDateTime.now());

        List<Colaborador> colaboradores = new ArrayList<>();

        List<RhAdmission> rhAdmissions = admiDigitalService.findByStatus(StatusEnum.INICIAL.toString());

        rhAdmissions.forEach(admi -> {
                    preAdmissaoId = admi.getPreAdmissaoId();
                    Colaborador colaborador = parseColaborador(admi);
                    colaboradores.add(colaborador);
                }
        );

        if (!colaboradores.isEmpty()){
            logger.info("====> total colaboradores status inicial: " + colaboradores.size());
            Stream<String> idAdmissionStream = pattern.splitAsStream(admiDigitalService.sendPreAdmission(colaboradores, preAdmissaoId));
            admiDigitalService.updateStatusPreAdmissao(rhAdmissions, idAdmissionStream, StatusEnum.PENDENTE_DOCUMENTO.toString());
        }

    }

    private Colaborador parseColaborador(RhAdmission admi) {
        Cidade cidade = new Cidade(Long.valueOf(admi.getCodigoCidade()), admi.getNomeCidade());
        Estado estado = new Estado(Integer.valueOf(admi.getCodigoEstado()), admi.getNomeEstado(), admi.getSiglaEstado());
        Endereco endereco = new Endereco(admi.getCep(), admi.getLogradouro(), Integer.valueOf(admi.getNumero()), admi.getComplemento(), admi.getBairro(), cidade, estado);
        return new Colaborador(admi.getCargo(), new BigDecimal(admi.getSalario()), admi.getNome(), admi.getEmail(), admi.getCelular(), admi.getDataAdmissao(), Integer.valueOf(admi.getTempoContrato()), admi.getMatricula(),endereco);
    }

}
