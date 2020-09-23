package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filial {

    private String id;
    private String codigo;
    private String nome;
    private String cnpj;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EnderecoFilial endereco;
}
