package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DependenteNaturalidade {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DependenteEstado estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DependenteCidade cidade;
}
