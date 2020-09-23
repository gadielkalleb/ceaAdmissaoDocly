package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dependente {

    private String _id;
    private String nome;
    private String mae;
    private String pai;
    private String nascidoEm;
    private Boolean incluirNoImpostoDeRenda;
    private Boolean temNecessidadesEspeciais;
    private String cpf;
    private String matriculaCertidaoNascimento;
    private String numeroRegistro;
    private String numeroLivroRegistro;
    private String numeroFolhaRegistro;
    private String numeroCartaoSaude;
    private Boolean estudante;
    private Boolean incapaz;

    private Parentesco parentesco;
    private EstadoCivil estadoCivil;
    private Sexo sexo;
    private DeclaracaoNascidoVivo declaracaoNascidoVivo;
    private DependentePaisNascimento paisNascimento;
    private DependenteNacionalidade nacionalidade;
    private DependenteGrauDeInstrucao grauDeInstrucao;
    private DependenteNaturalidade naturalidade;

}
