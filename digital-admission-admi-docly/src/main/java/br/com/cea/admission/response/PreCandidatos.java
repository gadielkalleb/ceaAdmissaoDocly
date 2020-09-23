package br.com.cea.admission.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PreCandidatos {

    private List<Candidato> candidatos;
}
