package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Cidade cidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Estado estado;

}
