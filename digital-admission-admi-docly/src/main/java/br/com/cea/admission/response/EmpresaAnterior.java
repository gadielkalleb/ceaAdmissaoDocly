package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaAnterior {

    private String empresa;
    private String admitidoEm;
    private String demitidoEm;
    private Boolean registrado;
    private String cargo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Ramo ramo;
}
