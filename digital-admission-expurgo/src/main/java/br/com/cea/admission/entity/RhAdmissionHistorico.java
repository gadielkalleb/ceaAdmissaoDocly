package br.com.cea.admission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="RH024T_ADMI_DIGITAL_HISTORICO")
public class RhAdmissionHistorico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="CANDIDATO_ID")
    private String candidatoId;
    @Column(name="SALARIO")
    private String salario;
    @Column(name="NOME")
    private String nome;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CELULAR")
    private String celular;
    @Column(name="ADMISSAOPREVISTAPARA")
    private String dataAdmisPrevista;
    @Column(name="DURACAODOCONTRATOEMDIAS")
    private String duracaoContratoDias;
    @Column(name="MATRICULA")
    private String matricula;
    @Column(name="CONTRATO")
    private String contrato;
    @Column(name="ADMISSAOCRIADAEM")
    private String dataAdmisCriada;
    @Column(name="DEVEINICIAROSTRABALHOSEM")
    private String deveIniciarOsTrabalhosEm;
    @Column(name="NASCIDO_EM")
    private String nascidoEm;
    @Column(name="CPF")
    private String cpf;
    @Column(name="MAE")
    private String mae;
    @Column(name="PAI")
    private String pai;
    @Column(name="NOME_CORPORATIVO")
    private String nomeCorporativo;
    @Column(name="TELEFONE_RECADO")
    private String telefoneRecado;
    @Column(name="ME_CONSIDERO_TRANSGENERO")
    private Boolean meConsideroTransgenero;

    @Column(name="ENDERECO_CANDIDATO_CEP")
    private String enderecoCandidatoCep;
    @Column(name="ENDERECO_CANDIDATO_LOGRADOURO")
    private String enderecoCandidatoLogradouro;
    @Column(name="ENDERECO_CANDIDATO_NUMERO")
    private String enderecoCandidatoNumero;
    @Column(name="ENDERECO_CANDIDATO_COMPLEMENTO")
    private String enderecoCandidatoComplemento;
    @Column(name="ENDERECO_CANDIDATO_BAIRRO")
    private String enderecoCandidatoBairro;
    @Column(name="ENDERECO_CANDIDATO_CIDADE_CODIGO")
    private String enderecoCandidatoCidadeCodigo;
    @Column(name="ENDERECO_CANDIDATO_CIDADE_NOME")
    private String enderecoCandidatoCidadeNome;
    @Column(name="ENDERECO_CANDIDATO_ESTADO_CODIGO")
    private String enderecoCandidatoEstadoCodigo;
    @Column(name="ENDERECO_CANDIDATO_ESTADO_NOME")
    private String enderecoCandidatoEstadoNome;
    @Column(name="ENDERECO_CANDIDATO_ESTADO_SIGLA")
    private String enderecoCandidatoEstadoSigla;

    @Column(name="ENDERECO_TRABALHO_CEP")
    private String enderecoTrabalhoCep;
    @Column(name="ENDERECO_TRABALHO_LOGRADOURO")
    private String enderecoTrabalhoLogradouro;
    @Column(name="ENDERECO_TRABALHO_NUMERO")
    private String enderecoTrabalhoNumero;
    @Column(name="ENDERECO_TRABALHO_COMPLEMENTO")
    private String enderecoTrabalhoComplemento;
    @Column(name="ENDERECO_TRABALHO_BAIRRO")
    private String enderecoTrabalhoBairro;
    @Column(name="ENDERECO_TRABALHO_CIDADE_CODIGO")
    private String enderecoTrabalhoCidadeCodigo;
    @Column(name="ENDERECO_TRABALHO_CIDADE_NOME")
    private String enderecoTrabalhoCidadeNome;
    @Column(name="ENDERECO_TRABALHO_ESTADO_CODIGO")
    private String enderecoTrabalhoEstadoCodigo;
    @Column(name="ENDERECO_TRABALHO_ESTADO_NOME")
    private String enderecoTrabalhoEstadoNome;
    @Column(name="ENDERECO_TRABALHO_ESTADO_SIGLA")
    private String enderecoTrabalhoEstadoSigla;

    @Column(name="ESTADO_CIVIL_CODIGO")
    private String estadoCivilCodigo;
    @Column(name="ESTADO_CIVIL_NOME")
    private String estadoCivilNome;

    @Column(name="GRAU_INSTRUCAO_CODIGO")
    private String grauInstrucaoCodigo;
    @Column(name="GRAU_INSTRUCAO_NOME")
    private String grauInstrucaoNome;

    @Column(name="NACIONALIDADE_CODIGO")
    private String nacionalidadeCodigo;
    @Column(name="NACIONALIDADE_NOME")
    private String nacionalidadeNome;
    @Column(name="NACIONALIDADE_SIGLA")
    private String nacionalidadeSigla;

    @Column(name="NATURAL_CIDADE_CODIGO")
    private String naturalidadeCidadeCodigo;
    @Column(name="NATURAL_CIDADE_NOME")
    private String naturalidadeCidadeNome;
    @Column(name="NATURAL_ESTADO_CODIGO")
    private String naturalidadeEstadoCodigo;
    @Column(name="NATURAL_ESTADO_NOME")
    private String naturalidadeEstadoNome;
    @Column(name="NATURAL_ESTADO_SIGLA")
    private String naturalidadeEstadoSigla;

    @Column(name="ORIENTACAO_SEXUAL_CODIGO")
    private String orientacaoSexualCodigo;
    @Column(name="ORIENTACAO_SEXUAL_NOME")
    private String orientacaoSexualNome;
    @Column(name="PIS")
    private String pis;
    @Column(name="RACA_CODIGO")
    private String racaCodigo;
    @Column(name="RACA_NOME")
    private String racaNome;

    @Column(name="SEXO_CODIGO")
    private String sexoCodigo;
    @Column(name="SEXO_NOME")
    private String sexoNome;

    @Column(name="TIPO_DEFICIENCIA_CODIGO")
    private String tipoDeficienciaCodigo;
    @Column(name="TIPO_DEFICIENCIA_NOME")
    private String tipoDeficienciaNome;

    @Column(name="RG_NUMERO")
    private String rgNumero;
    @Column(name="RG_EXPEDIDO_EM")
    private String rgExpedidoEm;
    @Column(name="RG_ORGAO_EMISSOR")
    private String rgOrgaoEmissor;
    /*@Column(name="RG_ORGAO_EMISSOR_CODIGO")
    private String rgOrgaoEmissorCodigo;
    @Column(name="RG_ORGAO_EMISSOR_NOME")
    private String rgOrgaoEmissorNome;*/
    @Column(name="RG_ESTADO_CODIGO")
    private String rgEstadoCodigo;
    @Column(name="RG_ESTADO_NOME")
    private String rgEstadoNome;
    @Column(name="RG_ESTADO_SIGLA")
    private String rgEstadoSigla;

    @Column(name="EMPRESA_ID")
    private String empresaId;
    @Column(name="EMPRESA_CODIGO")
    private String empresaCodigo;
    @Column(name="EMPRESA_NOME")
    private String empresaNome;
    @Column(name="EMPRESA_CNPJ")
    private String empresaCnpj;

    @Column(name="FILIAL_ID")
    private String filialId;
    @Column(name="FILIAL_CODIGO")
    private String filialCodigo;
    @Column(name="FILIAL_NOME")
    private String filialNome;
    @Column(name="FILIAL_CNPJ")
    private String filialCnpj;
    @Column(name="FILIAL_ENDERECO_CEP")
    private String filialEnderecoCep;
    @Column(name="FILIAL_ENDERECO_LOGRADOURO")
    private String filialEnderecoLogradouro;
    @Column(name="FILIAL_ENDERECO_NUMERO")
    private String filialEnderecoNumero;
    @Column(name="FILIAL_ENDERECO_BAIRRO")
    private String filialEnderecoBairro;
    @Column(name="FILIAL_ENDERECO_CIDADE_NOME")
    private String filialEnderecoCidadeNome;
    @Column(name="FILIAL_ENDERECO_CIDADE_CODIGO")
    private String filialEnderecoCidadeCodigo;
    @Column(name="FILIAL_ENDERECO_ESTADO_NOME")
    private String filialEnderecoEstadoNome;
    @Column(name="FILIAL_ENDERECO_ESTADO_CODIGO")
    private String filialEnderecoEstadoCodigo;
    @Column(name="FILIAL_ENDERECO_ESTADO_SIGLA")
    private String filialEnderecoEstadoSigla;

    @Column(name="CENTRO_CUSTO_ID")
    private String centroCustoId;
    @Column(name="CENTRO_CUSTO_CODIGO")
    private String centroCustoCodigo;
    @Column(name="CENTRO_CUSTO_NOME")
    private String centroCustoNome;

    @Column(name="AREA_ID")
    private String areaId;
    @Column(name="AREA_CODIGO")
    private String areaCodigo;
    @Column(name="AREA_NOME")
    private String areaNome;

    @Column(name="GESTOR_ID")
    private String gestorId;
    @Column(name="GESTOR_NOME")
    private String gestorNome;
    @Column(name="GESTOR_EMAIL")
    private String gestorEmail;
    @Column(name="GESTOR_CODIGO")
    private String gestorCodigo;
    @Column(name="GESTOR_CLIENT_ID")
    private String gestorClientId;

    @Column(name="CARGO_NOME")
    private String cargoNome;

    @Column(name="VINCULO_EMPREGATICIO_CODIGO")
    private String vinculoEmpregaticioCodigo;
    @Column(name="VINCULO_EMPREGATICIO_DESCRICAO")
    private String vinculoEmpregaticioDescricao;

    @Column(name="EXPEDIENTE_HORAS_SEMANAIS")
    private String expedienteHorasSemanais;
    @Column(name="EXPEDIENTE_HORAS_MENSAIS")
    private String expedienteHorasMensais;
    @Column(name="EXPEDIENTE_SEGUNDA_FEIRA_TEM_EXPEDIENTE")
    private Boolean expedienteSegundaTemExpediente;
    @Column(name="EXPEDIENTE_SEGUNDA_FEIRA_INICIO")
    private String expedienteSegundaInicio;
    @Column(name="EXPEDIENTE_SEGUNDA_FEIRA_INTERVALO")
    private String expedienteSegundaIntervalo;
    @Column(name="EXPEDIENTE_SEGUNDA_FEIRA_TERMINO")
    private String expedienteSegundaTermino;
    @Column(name="EXPEDIENTE_TERCA_FEIRA_TEM_EXPEDIENTE")
    private Boolean expedienteTercaTemExpediente;
    @Column(name="EXPEDIENTE_TERCA_FEIRA_INICIO")
    private String expedienteTercaInicio;
    @Column(name="EXPEDIENTE_TERCA_FEIRA_INTERVALO")
    private String expedienteTercaIntervalo;
    @Column(name="EXPEDIENTE_TERCA_FEIRA_TERMINO")
    private String expedienteTercaTermino;
    @Column(name="EXPEDIENTE_QUARTA_FEIRA_TEM_EXPEDIENTE")
    private Boolean expedienteQuartaTemExpediente;
    @Column(name="EXPEDIENTE_QUARTA_FEIRA_INICIO")
    private String expedienteQuartaInicio;
    @Column(name="EXPEDIENTE_QUARTA_FEIRA_INTERVALO")
    private String expedienteQuartaIntervalo;
    @Column(name="EXPEDIENTE_QUARTA_FEIRA_TERMINO")
    private String expedienteQuartaTermino;
    @Column(name="EXPEDIENTE_QUINTA_FEIRA_TEM_EXPEDIENTE")
    private Boolean expedienteQuintaTemExpediente;
    @Column(name="EXPEDIENTE_QUINTA_FEIRA_INICIO")
    private String expedienteQuintaInicio;
    @Column(name="EXPEDIENTE_QUINTA_FEIRA_INTERVALO")
    private String expedienteQuintaIntervalo;
    @Column(name="EXPEDIENTE_QUINTA_FEIRA_TERMINO")
    private String expedienteQuintaTermino;
    @Column(name="EXPEDIENTE_SEXTA_FEIRA_TEM_EXPEDIENTE")
    private Boolean expedienteSextaTemExpediente;
    @Column(name="EXPEDIENTE_SEXTA_FEIRA_INICIO")
    private String expedienteSextaInicio;
    @Column(name="EXPEDIENTE_SEXTA_FEIRA_INTERVALO")
    private String expedienteSextaIntervalo;
    @Column(name="EXPEDIENTE_SEXTA_FEIRA_TERMINO")
    private String expedienteSextaTermino;
    @Column(name="EXPEDIENTE_SABADO_TEM_EXPEDIENTE")
    private Boolean expedienteSabadoTemExpediente;
    @Column(name="EXPEDIENTE_SABADO_INICIO")
    private String expedienteSabadoInicio;
    @Column(name="EXPEDIENTE_SABADO_INTERVALO")
    private String expedienteSabadoIntervalo;
    @Column(name="EXPEDIENTE_SABADO_TERMINO")
    private String expedienteSabadoTermino;
    @Column(name="EXPEDIENTE_DOMINGO_TEM_EXPEDIENTE")
    private Boolean expedienteDomingoTemExpediente;
    @Column(name="EXPEDIENTE_DOMINGO_INICIO")
    private String expedienteDomingoInicio;
    @Column(name="EXPEDIENTE_DOMINGO_INTERVALO")
    private String expedienteDomingoIntervalo;
    @Column(name="EXPEDIENTE_DOMINGO_TERMINO")
    private String expedienteDomingoTermino;

    @Column(name="ESTRANGEIRO_NATURALIZADO")
    private String estrangeiroNaturalizado;
    @Column(name="ESTRANGEIRO_NATURALIZADO_EM")
    private String estrangeiroNaturalizadoEm;
    @Column(name="ESTRANGEIRO_CASADO_COM_BRASILEIRO")
    private Boolean estrangeiroCasadoComBrasileiro;
    @Column(name="ESTRANGEIRO_TEM_FILHO_COM_BRASILEIRO")
    private Boolean estrangeiroTemFilhoComBrasileiro;
    @Column(name="ESTRANGEIRO_CHEGOU_AO_PAIS_EM")
    private String estrangeiroChegouAoPaisEm;
    @Column(name="ESTRANGEIRO_SITUACAO_CODIGO")
    private String estrangeiroSituacaoCodigo;
    @Column(name="ESTRANGEIRO_SITUACAO_NOME")
    private String estrangeiroSituacaoNome;
    @Column(name="ESTRANGEIRO_TIPO_VISTO_CODIGO")
    private String estrangeiroTipoVistoCodigo;
    @Column(name="ESTRANGEIRO_TIPO_VISTO_NOME")
    private String estrangeiroTipoVistoNome;

    @Column(name="DEPENDENTES")
    private String dependentes;

    @Column(name="MATRICULA_CERTIDAO_NASCIMENTO")
    private String matriculaCertidaoNascimento;
    @Column(name="NUMERO_REGISTRO")
    private String numeroRegistro;
    @Column(name="NUMERO_LIVRO_REGISTRO")
    private String numeroLivroRegistro;
    @Column(name="NUMERO_FOLHA_REGISTRO")
    private String numeroFolhaRegistro;
    @Column(name="NUMERO_CARTAO_SAUDE")
    private String numeroCartaoSaude;
    @Column(name="ESTUDANTE")
    private Boolean estudante;
    @Column(name="INCAPAZ")
    private Boolean incapaz;

    @Column(name="FORMACOES")
    private String formacoes;

    @Column(name="EMPRESAS_ANTERIORES")
    private String empresasAnteriores;

    @Column(name="IDIOMAS")
    private String idiomas;

    @Column(name="CERTIFICACOES")
    private String certificacoes;

    @Column(name="CONTA_BANCO")
    private String contaBanco;
    @Column(name="CONTA_AGENCIA")
    private String contaAgencia;
    @Column(name="CONTA_NUMERO")
    private String contaNumero;
    @Column(name="CONTA_TIPO_CODIGO")
    private String contaTipoCodigo;
    @Column(name="CONTA_TIPO_NOME")
    private String contaTipoNome;

    @Column(name="CNH_NUMERO")
    private String cnhNumero;
    @Column(name="CNH_VENCE_EM")
    private String cnhVenceEm;
    @Column(name="CNH_PRIMEIRA_HABILITACAO")
    private String cnhPrimeiraHabilitacao;
    @Column(name="CNH_EMITIDA_EM")
    private String cnhEmitidaEm;
    @Column(name="CNH_CATEGORIA_NOME")
    private String cnhCategoriaNome;
    @Column(name="CNH_CATEGORIA_CODIGO")
    private String cnhCategoriaCodigo;
    @Column(name="CNH_ESTADO_NOME")
    private String cnhEstadoNome;
    @Column(name="CNH_ESTADO_SIGLE")
    private String cnhEstadoSigla;
    @Column(name="CNH_ESTADO_CODIGO")
    private String cnhEstadoCodigo;

    @Column(name="TITULO_ELEITOR_NUMERO")
    private String tituloEleitorNumero;
    @Column(name="TITULO_ELEITOR_ZONA")
    private String tituloEleitorZona;
    @Column(name="TITULO_ELEITOR_SECAO")
    private String tituloEleitorSecao;
    @Column(name="TITULO_ELEITOR_EMITIDO_EM")
    private String tituloEleitorEmitidoEm;
    @Column(name="TITULO_ELEITOR_CIDADE_CODIGO")
    private String tituloEleitorCidadeCodigo;
    @Column(name="TITULO_ELEITOR_CIDADE_NOME")
    private String tituloEleitorCidadeNome;
    @Column(name="TITULO_ELEITOR_ESTADO_CODIGO")
    private String tituloEleitorEstadoCodigo;
    @Column(name="TITULO_ELEITOR_ESTADO_NOME")
    private String tituloEleitorEstadoNome;
    @Column(name="TITULO_ELEITOR_ESTADO_SIGLA")
    private String tituloEleitorEstadoSigla;

    @Column(name="RESERVISTA_NUMERO")
    private String reservistaNumero;
    @Column(name="RESERVISTA_RA")
    private String reservistaRa;
    @Column(name="RESERVISTA_SERIE")
    private String reservistaSerie;

    @Column(name="DOCUMENTO_CLASSE_NUMERO")
    private String documentoClasseNumero;
    @Column(name="DOCUMENTO_CLASSE_EXPEDIDO_EM")
    private String documentoClasseExpedidoEm;
    @Column(name="DOCUMENTO_CLASSE_VENCE_EM")
    private String documentoClasseVenceem;
    @Column(name="DOCUMENTO_CLASSE_TIPO_CODIGO")
    private String documentoClasseTipoCodigo;
    @Column(name="DOCUMENTO_CLASSE_TIPO_NOME")
    private String documentoClasseTipoNome;
    @Column(name="DOCUMENTO_CLASSE_CIDADE_CODIGO")
    private String documentoClasseCidadeCodigo;
    @Column(name="DOCUMENTO_CLASSE_CIDADE_NOME")
    private String documentoClasseCidadeNome;
    @Column(name="DOCUMENTO_CLASSE_ESTADO_CODIGO")
    private String documentoClasseEstadoCodigo;
    @Column(name="DOCUMENTO_CLASSE_ESTADO_NOME")
    private String documentoClasseEstadoNome;
    @Column(name="DOCUMENTO_CLASSE_ESTADO_SIGLA")
    private String documentoClasseEstadoSigla;
    @Column(name="DOCUMENTO_CLASSE_ORGAO_EMISSOR_NOME")
    private String documentoClasseOrgaoEmissorNome;
    @Column(name="DOCUMENTO_CLASSE_ORGAO_EMISSOR_CODIGO")
    private String documentoClasseOrgaoEmissorCodigo;

    @Column(name="CTPS_NUMERO")
    private String ctpsNumero;
    @Column(name="CTPS_SERIE")
    private String ctpsSerie;
    @Column(name="CTPS_EMITIDA_EM")
    private String ctpsEmitidaEm;
    @Column(name="CTPS_RECEBEU_SEGURO_DESEMPREGO")
    private String ctpsRecebeuSeguroDesemprego;
    @Column(name="CTPS_VENCE_EM")
    private String ctpsVenceEm;
    @Column(name="CTPS_ESTADO_CODIGO")
    private String ctpsEstadoCodigo;
    @Column(name="CTPS_ESTADO_NOME")
    private String ctpsEstadoNome;
    @Column(name="CTPS_ESTADO_SIGLA")
    private String ctpsEstadoSigla;
    @Column(name="CTPS_APOSENTADORIA_APOSENTOU_EM")
    private String ctpsAposentadoriaAposentouEm;
    @Column(name="CTPS_APOSENTADORIA_NUMERO_BENEFICIO")
    private String ctpsAposentadoriaNumeroBeneficio;
}
