package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admissao {

    private String preAdmissaoId;
    private List<Colaborador> colaboradores;
}
