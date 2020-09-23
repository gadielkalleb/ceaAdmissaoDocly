package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cnh {

    private String numero;
    private String venceEm;
    private String emitidaEm;
    private String primeiraHabilitcaoEmitidaEm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoCnh estado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CnhCategoria cnhCategoria;
}
