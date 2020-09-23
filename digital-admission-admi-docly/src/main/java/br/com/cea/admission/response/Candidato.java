package br.com.cea.admission.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidato {

    private String _id;
    private String salario;
    private String nome;
    private String email;
    private String celular;
    private String admissaoPrevistaPara;
    private String duracaoDoContratoEmDias;
    private String matricula;
    private String contrato;
    private String admissaoCriadaEm;
    private String deveIniciarOsTrabalhosEm;
    private String nascidoEm;
    private String cpf;
    private String mae;
    private String pai;
    private String nomeCorporativo;
    private String telefoneRecado;
    private Boolean meConsideroTransgenero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EnderecoCandidato endereco;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EstadoCivil estadoCivil;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GrauDeInstrucao grauDeInstrucao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Nacionalidade nacionalidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Naturalidade naturalidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrientacaoSexual orientacaoSexual;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pis pis;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Raca raca;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Sexo sexo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RG rg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Endereco enderecoDeTrabalho;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Empresa empresa;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Filial filial;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CentroDeCusto centroDeCusto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Area area;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Gestor gestor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Cargo cargo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private VinculoEmpregaticio vinculoEmpregaticio;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Expediente expediente;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Estrangeiro estrangeiro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Conta conta;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Cnh cnh;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TituloEleitor tituloEleitor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Reservista reservista;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoDeVisto tipoDeVisto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DocumentoDeClasse documentoDeClasse;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Ctps ctps;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TipoDeficiencia tipoDeficiencia;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Dependente> dependentes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Formacao> formacoes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EmpresaAnterior> empresasAnteriores;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Idioma> idiomas;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Certificacao> certificacoes;
}
