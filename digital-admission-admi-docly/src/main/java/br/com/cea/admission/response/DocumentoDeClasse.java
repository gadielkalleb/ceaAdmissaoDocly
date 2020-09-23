package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentoDeClasse {

    private String numero;
    private String expedidoEm;
    private String venceEm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoDocumentoDeClasse tipo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CidadeDocumentoDeClasse cidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoDocumentoDeClasse estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrgaoEmissorDocumentoDeClasse orgaoEmissor;
}
