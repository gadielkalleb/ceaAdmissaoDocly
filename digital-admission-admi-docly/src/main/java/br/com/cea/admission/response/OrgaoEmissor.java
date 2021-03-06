package br.com.cea.admission.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrgaoEmissor {

    private String codigo;
    private String nome;
}
