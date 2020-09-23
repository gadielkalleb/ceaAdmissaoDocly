package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Estrangeiro {

    private String naturalizado;
    private String naturalizadoEm;
    private Boolean casadoComBrasileiro;
    private Boolean temFilhoComBrasileiro;
    private String chegouAoPaisEm;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Situacao situacao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoDeVisto tipoDeVisto;
}
