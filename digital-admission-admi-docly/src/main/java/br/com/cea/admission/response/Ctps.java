package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ctps {

    private String numero;
    private String serie;
    private String emitidaEm;
    private Boolean recebeSeguroDesemprego;
    private String venceEm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoCtps estado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Aposentadoria aposentadoria;
}
