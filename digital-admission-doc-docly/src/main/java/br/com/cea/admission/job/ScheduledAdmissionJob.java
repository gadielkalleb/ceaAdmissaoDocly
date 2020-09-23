package br.com.cea.admission.job;

import br.com.cea.admission.entity.RhAdmission;
import br.com.cea.admission.entity.RhAdmissionArquivo;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import br.com.cea.admission.request.Request;
import br.com.cea.admission.service.AdmiDigitalArquivoService;
import br.com.cea.admission.service.AdmiDigitalService;
import br.com.cea.admission.service.DoclyService;
import br.com.cea.admission.vo.StatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ScheduledAdmissionJob {

    private static final Logger logger = LogManager.getLogger(ScheduledAdmissionJob.class);

    @Autowired
    private AdmiDigitalService admiDigitalService;

    @Autowired
    private AdmiDigitalArquivoService admiDigitalArquivoService;

    @Autowired
    private DoclyService doclyService;

    @Autowired
    private AdmiDigitalRepository repository;

    Map<String, List<RhAdmissionArquivo>> groupByCpfMap = null;

    Request request = null;

    public void execute() throws Exception {

        logger.info("Start process digital admission: => " + LocalDateTime.now());

        admiDigitalService.findByStatus(StatusEnum.PENDENTE_DOCUMENTO.toString()).forEach(pendentes -> {

            groupByCpfMap = admiDigitalArquivoService.findByCpfAndStatus(pendentes.getCpf(),null).stream()
                    .collect(Collectors.groupingBy(RhAdmissionArquivo::getCpf));

            groupByCpfMap.forEach((s, rhAdmissionArquivos) -> {

                rhAdmissionArquivos.forEach(rhAdmissionArquivo -> {

                    request = new Request();
                    request.setNome(rhAdmissionArquivo.getNome());
                    request.setExtensao(rhAdmissionArquivo.getNome().substring(rhAdmissionArquivo.getNome().length() - 3));
                    request.setImagem(Base64.getEncoder().encodeToString(rhAdmissionArquivo.getConteudo()));

                    request.setColaboradorId(pendentes.getIdAdmissaoDocley());
                    this.postUploadDoc();
                    admiDigitalArquivoService.updateStatus(rhAdmissionArquivo,StatusEnum.ENVIADO.toString());
                });

                this.updateStatus(pendentes);

            });

        });

    }

    private void updateStatus(RhAdmission pendentes)  {
        try {
            admiDigitalService.updateStatus(pendentes, StatusEnum.DOCUMENTOS_ENVIADOS.toString());
        } catch (Exception e) {
            logger.error("====> updateStatus - Exception: " + e.getMessage());
            System.exit(1);
        }
    }

    private void postUploadDoc()  {
        try {
            doclyService.postUploadDoc(request);
        } catch (Exception e) {
            logger.error("====> postUploadDoc - Exception: " + e.getMessage());
            System.exit(1);
        }
    }

}
