package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TituloEleitor {

    private String numero;
    private String zona;
    private String secao;
    private String emitidoEm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CidadeTitulo cidade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoTitulo estado;

}
