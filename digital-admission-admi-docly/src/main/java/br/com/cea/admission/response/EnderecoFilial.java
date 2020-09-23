package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoFilial {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CidadeFilial cidadeFilial;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoFilial estadoFilial;

}
