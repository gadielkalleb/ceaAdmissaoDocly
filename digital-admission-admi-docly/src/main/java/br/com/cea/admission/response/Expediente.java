package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Expediente {

    private String horasSemanais;
    private String horasMensais;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SegundaFeira segundaFeira;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TercaFeira tercaFeira;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private QuartaFeira quartaFeira;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private QuintaFeira quintaFeira;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SextaFeira sextaFeira;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Sabado sabado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Domingo domingo;
}
