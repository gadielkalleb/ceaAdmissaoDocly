package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Formacao {

    private String iniciadoEm;
    private String concluidoEm;

    private Tipo tipo;
    private Curso curso;
    private Especializacao especializacao;
    private EntidadeDeEnsino entidadeDeEnsino;
    private Situacao situacao;

}
