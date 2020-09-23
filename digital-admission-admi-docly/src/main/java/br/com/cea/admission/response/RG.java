package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RG {

    private String numero;
    private String expedidoEm;
    private String orgaoEmissor;

    /*@JsonInclude(JsonInclude.Include.NON_NULL)
    private OrgaoEmissor orgaoEmissor;*/

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoRg estado;
}
