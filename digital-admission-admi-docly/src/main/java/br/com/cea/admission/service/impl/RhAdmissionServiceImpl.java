package br.com.cea.admission.service.impl;

import br.com.cea.admission.entity.RhAdmissionDigital;
import br.com.cea.admission.entity.RhAdmissionRetornoDocly;
import br.com.cea.admission.enums.StatusEnum;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import br.com.cea.admission.repository.AdmiDigitalRetornoRepository;
import br.com.cea.admission.response.Candidato;
import br.com.cea.admission.service.RhAdmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RhAdmissionServiceImpl implements RhAdmissionService {

    private static final Logger logger = LogManager.getLogger(RhAdmissionServiceImpl.class);

    @Autowired
    private AdmiDigitalRetornoRepository repositoryRetornoDocly;

    @Autowired
    private AdmiDigitalRepository repositoryDigital;

    public void saveCandidato(Candidato candidato) throws Exception {
        try {
            if (!repositoryRetornoDocly.existsByCandidatoId(candidato.get_id())) {
                RhAdmissionRetornoDocly rhAdmissionRetornoDocly = this.parseCandidato(candidato);
                if (rhAdmissionRetornoDocly != null) {
                    repositoryRetornoDocly.save(rhAdmissionRetornoDocly);
                }
            }
        } catch (Exception e) {
            logger.error("====> saveCandidato - Exception: " + candidato.get_id() + " -> " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void updateStatus(Candidato candidato) throws Exception {
        try {
            RhAdmissionDigital rhAdmission = repositoryDigital.getByPreAdmissaoId(candidato.get_id());
            if(!ObjectUtils.isEmpty(rhAdmission)){
                rhAdmission.setStatus(StatusEnum.ADMITIDO.toString());
                rhAdmission.setDataStatus(String.valueOf(LocalDateTime.now()));
                repositoryDigital.save(rhAdmission);
            }
        } catch (Exception e) {
            logger.error("====> updateStatus - Exception: " + candidato.get_id() + " -> " + e.getMessage());
            System.exit(1);
        }
    }

    private RhAdmissionRetornoDocly parseCandidato(Candidato candidato) throws Exception {

        final StringBuilder dependentes = new StringBuilder();
        final StringBuilder formacoes = new StringBuilder();
        final StringBuilder empresasAnteriores = new StringBuilder();
        final StringBuilder idiomas = new StringBuilder();
        final StringBuilder certificacoes = new StringBuilder();

        try {
                RhAdmissionRetornoDocly admission = new RhAdmissionRetornoDocly();

                admission.setCandidatoId(candidato.get_id());
                admission.setSalario(candidato.getSalario());
                admission.setNome(candidato.getNome());
                admission.setEmail(candidato.getEmail());
                admission.setCelular(candidato.getCelular());
                admission.setDataAdmisPrevista(candidato.getAdmissaoPrevistaPara());
                admission.setDuracaoContratoDias(candidato.getDuracaoDoContratoEmDias());
                admission.setMatricula(candidato.getMatricula());
                //admission.setContrato(candidato.getContrato());
                admission.setDataAdmisCriada(candidato.getAdmissaoCriadaEm());
                admission.setDeveIniciarOsTrabalhosEm(candidato.getDeveIniciarOsTrabalhosEm());
                admission.setNascidoEm(candidato.getNascidoEm());
                admission.setCpf(candidato.getCpf());
                admission.setMae(candidato.getMae());
                admission.setPai(candidato.getPai());
                admission.setNomeCorporativo(candidato.getNomeCorporativo());
                admission.setTelefoneRecado(candidato.getTelefoneRecado());
                admission.setMeConsideroTransgenero(candidato.getMeConsideroTransgenero());
                admission.setCargoNome( candidato.getCargo().getNome());

                Optional.ofNullable(candidato.getEndereco()).ifPresent(endCandidato -> {
                    admission.setEnderecoCandidatoCep(endCandidato.getCep());
                    admission.setEnderecoCandidatoLogradouro(endCandidato.getLogradouro());
                    admission.setEnderecoCandidatoNumero(endCandidato.getNumero());
                    admission.setEnderecoCandidatoComplemento(endCandidato.getComplemento());
                    admission.setEnderecoCandidatoBairro(endCandidato.getBairro());

                    Optional.ofNullable(candidato.getEndereco().getCidade()).ifPresent(cidade -> {
                        admission.setEnderecoCandidatoCidadeCodigo(cidade.getCodigo());
                        admission.setEnderecoCandidatoCidadeNome(cidade.getNome());
                    });

                    Optional.ofNullable(candidato.getEndereco().getEstado()).ifPresent(estado -> {
                        admission.setEnderecoCandidatoEstadoCodigo(estado.getCodigo());
                        admission.setEnderecoCandidatoEstadoNome(estado.getNome());
                        admission.setEnderecoCandidatoEstadoSigla(estado.getSigla());
                    });
                });

                Optional.ofNullable(candidato.getEnderecoDeTrabalho()).ifPresent(endTrabalho -> {
                    admission.setEnderecoTrabalhoCep(endTrabalho.getCep());
                    admission.setEnderecoTrabalhoLogradouro(endTrabalho.getLogradouro());
                    admission.setEnderecoTrabalhoNumero(endTrabalho.getNumero());
                    admission.setEnderecoTrabalhoComplemento(endTrabalho.getComplemento());
                    admission.setEnderecoTrabalhoBairro(endTrabalho.getBairro());

                   Optional.ofNullable(candidato.getEnderecoDeTrabalho().getCidade()).ifPresent(cidade -> {
                        admission.setEnderecoTrabalhoCidadeCodigo(cidade.getCodigo());
                        admission.setEnderecoTrabalhoCidadeNome(cidade.getNome());
                    });

                    Optional.ofNullable(candidato.getEnderecoDeTrabalho().getEstado()).ifPresent(estado -> {
                        admission.setEnderecoTrabalhoEstadoCodigo(estado.getCodigo());
                        admission.setEnderecoTrabalhoEstadoNome(estado.getNome());
                        admission.setEnderecoTrabalhoEstadoSigla(estado.getSigla());
                    });
                });

                Optional.ofNullable(candidato.getEmpresa()).ifPresent(empresa -> {
                    admission.setEmpresaId(empresa.getId());
                    admission.setEmpresaCodigo(empresa.getCodigo());
                    admission.setEmpresaNome(empresa.getNome());
                    admission.setEmpresaCnpj(empresa.getCnpj());
                });

                Optional.ofNullable(candidato.getPis()).ifPresent(pis -> {
                    admission.setPis(pis.getNumero());
                });

                Optional.ofNullable(candidato.getFilial()).ifPresent(filial -> {
                    admission.setFilialId(filial.getId());
                    admission.setFilialCodigo(filial.getCodigo());
                    admission.setFilialNome(filial.getNome());
                    admission.setFilialCnpj(filial.getCnpj());

                    Optional.ofNullable(filial.getEndereco()).ifPresent(endereco ->   {
                        admission.setFilialEnderecoCep(endereco.getCep());
                        admission.setFilialEnderecoLogradouro(endereco.getLogradouro());
                        admission.setFilialEnderecoNumero(endereco.getNumero());
                        admission.setFilialEnderecoBairro(endereco.getBairro());

                        Optional.ofNullable(endereco.getCidadeFilial()).ifPresent(cidade -> {
                            admission.setFilialEnderecoCidadeCodigo(cidade.getCodigo());
                            admission.setFilialEnderecoCidadeNome(cidade.getNome());
                        });

                        Optional.ofNullable(endereco.getEstadoFilial()).ifPresent(estado -> {
                            admission.setFilialEnderecoEstadoCodigo(estado.getCodigo());
                            admission.setFilialEnderecoEstadoNome(estado.getNome());
                            admission.setFilialEnderecoEstadoSigla(estado.getSigla());
                        });

                    });
                });

                Optional.ofNullable(candidato.getCentroDeCusto()).ifPresent(centroDeCusto -> {
                    admission.setCentroCustoId(centroDeCusto.getId());
                    admission.setCentroCustoCodigo(centroDeCusto.getCodigo());
                    admission.setCentroCustoNome(centroDeCusto.getNome());
                });

                Optional.ofNullable(candidato.getArea()).ifPresent(area -> {
                    admission.setAreaId(area.getId());
                    admission.setAreaCodigo(area.getCodigo());
                    admission.setAreaNome(area.getNome());
                });

                Optional.ofNullable(candidato.getGestor()).ifPresent(gestor -> {
                    admission.setGestorId(gestor.getId());
                    admission.setGestorNome(gestor.getNome());
                    admission.setGestorEmail(gestor.getEmail());
                    admission.setGestorCodigo(gestor.getCodigo());
                    admission.setGestorClientId(gestor.getClientId());
                });

                Optional.ofNullable(candidato.getVinculoEmpregaticio()).ifPresent(vinculoEmpregaticio -> {
                    admission.setVinculoEmpregaticioCodigo(vinculoEmpregaticio.getCodigo());
                    admission.setVinculoEmpregaticioDescricao(vinculoEmpregaticio.getDescricao());
                });

                admission.setExpedienteHorasSemanais(candidato.getExpediente().getHorasSemanais());
                admission.setExpedienteHorasMensais(candidato.getExpediente().getHorasMensais());

                admission.setExpedienteSegundaTemExpediente(candidato.getExpediente().getSegundaFeira().getTemExpediente());
                admission.setExpedienteSegundaInicio(candidato.getExpediente().getSegundaFeira().getInicio());
                admission.setExpedienteSegundaIntervalo(candidato.getExpediente().getSegundaFeira().getIntervalo());
                admission.setExpedienteSegundaTermino(candidato.getExpediente().getSegundaFeira().getTermino());

                admission.setExpedienteTercaTemExpediente(candidato.getExpediente().getTercaFeira().getTemExpediente());
                admission.setExpedienteTercaInicio(candidato.getExpediente().getTercaFeira().getInicio());
                admission.setExpedienteTercaIntervalo(candidato.getExpediente().getTercaFeira().getIntervalo());
                admission.setExpedienteTercaTermino(candidato.getExpediente().getTercaFeira().getTermino());

                admission.setExpedienteQuartaTemExpediente(candidato.getExpediente().getQuartaFeira().getTemExpediente());
                admission.setExpedienteQuartaInicio(candidato.getExpediente().getQuartaFeira().getInicio());
                admission.setExpedienteQuartaIntervalo(candidato.getExpediente().getQuartaFeira().getIntervalo());
                admission.setExpedienteQuartaTermino(candidato.getExpediente().getQuartaFeira().getTermino());

                admission.setExpedienteQuintaTemExpediente(candidato.getExpediente().getQuintaFeira().getTemExpediente());
                admission.setExpedienteQuintaInicio(candidato.getExpediente().getQuintaFeira().getInicio());
                admission.setExpedienteQuintaIntervalo(candidato.getExpediente().getQuintaFeira().getIntervalo());
                admission.setExpedienteQuintaTermino(candidato.getExpediente().getQuintaFeira().getTermino());

                admission.setExpedienteSextaTemExpediente(candidato.getExpediente().getSextaFeira().getTemExpediente());
                admission.setExpedienteSextaInicio(candidato.getExpediente().getSextaFeira().getInicio());
                admission.setExpedienteSextaIntervalo(candidato.getExpediente().getSextaFeira().getIntervalo());
                admission.setExpedienteSextaTermino(candidato.getExpediente().getSextaFeira().getTermino());

                admission.setExpedienteSabadoTemExpediente(candidato.getExpediente().getSabado().getTemExpediente());
                admission.setExpedienteSabadoInicio(candidato.getExpediente().getSabado().getInicio());
                admission.setExpedienteSabadoIntervalo(candidato.getExpediente().getSabado().getIntervalo());
                admission.setExpedienteSabadoTermino(candidato.getExpediente().getSabado().getTermino());

                admission.setExpedienteDomingoTemExpediente(candidato.getExpediente().getDomingo().getTemExpediente());
                admission.setExpedienteDomingoInicio(candidato.getExpediente().getDomingo().getInicio());
                admission.setExpedienteDomingoIntervalo(candidato.getExpediente().getDomingo().getIntervalo());
                admission.setExpedienteDomingoTermino(candidato.getExpediente().getDomingo().getTermino());

                Optional.ofNullable(candidato.getEstrangeiro()).ifPresent(estrangeiro -> {
                    admission.setEstrangeiroNaturalizado(estrangeiro.getNaturalizado());
                    admission.setEstrangeiroNaturalizadoEm(estrangeiro.getNaturalizadoEm());
                    admission.setEstrangeiroCasadoComBrasileiro(estrangeiro.getCasadoComBrasileiro());
                    admission.setEstrangeiroTemFilhoComBrasileiro(estrangeiro.getTemFilhoComBrasileiro());
                    admission.setEstrangeiroChegouAoPaisEm(estrangeiro.getChegouAoPaisEm());

                    Optional.ofNullable(candidato.getEstrangeiro().getSituacao()).ifPresent(situacao -> {
                        admission.setEstrangeiroSituacaoCodigo(situacao.getCodigo());
                        admission.setEstrangeiroSituacaoNome(situacao.getNome());
                    });

                    Optional.ofNullable(candidato.getEstrangeiro().getTipoDeVisto()).ifPresent(tipoVisto -> {
                        admission.setEstrangeiroTipoVistoCodigo(tipoVisto.getCodigo());
                        admission.setEstrangeiroTipoVistoNome(tipoVisto.getNome());
                    });
                });

                candidato.getDependentes().forEach((dependente)->{
                    dependentes.append(dependente + ";");
                });

                candidato.getFormacoes().forEach((formacao)->{
                    formacoes.append(formacao + ";");
                });

                candidato.getEmpresasAnteriores().forEach((empresa)->{
                    empresasAnteriores.append(empresa + ";");
                });

                candidato.getIdiomas().forEach((idioma) -> {
                    idiomas.append(idioma + ";");
                });

                candidato.getCertificacoes().forEach((certificacao) -> {
                    certificacoes.append(certificacao + ";");
                });

                admission.setDependentes(dependentes.toString());
                admission.setFormacoes(formacoes.toString());
                admission.setEmpresasAnteriores(empresasAnteriores.toString());
                admission.setIdiomas(idiomas.toString());
                admission.setIdiomas(certificacoes.toString());

                Optional.ofNullable(candidato.getConta()).ifPresent(conta -> {
                    admission.setContaAgencia(conta.getAgencia());
                    admission.setContaNumero(conta.getNumero());
                    admission.setContaBanco(conta.getBanco());
                    admission.setContaTipoCodigo(conta.getTipo().getCodigo());
                    admission.setContaTipoNome(conta.getTipo().getNome());
                });

                Optional.ofNullable(candidato.getEstadoCivil()).ifPresent(estadoCivil ->  {
                    admission.setEstadoCivilCodigo(estadoCivil.getCodigo());
                    admission.setEstadoCivilNome(estadoCivil.getNome());
                });

                Optional.ofNullable(candidato.getGrauDeInstrucao()).ifPresent(grauDeInstrucao ->   {
                    admission.setGrauInstrucaoCodigo(grauDeInstrucao.getCodigo());
                    admission.setGrauInstrucaoNome(grauDeInstrucao.getNome());
                });

                Optional.ofNullable(candidato.getCnh()).ifPresent(cnh ->  {
                    admission.setCnhEmitidaEm(cnh.getEmitidaEm());
                    admission.setCnhNumero(cnh.getNumero());
                    admission.setCnhPrimeiraHabilitacao(cnh.getPrimeiraHabilitcaoEmitidaEm());
                    admission.setCnhVenceEm(cnh.getVenceEm());

                    Optional.ofNullable(cnh.getCnhCategoria()).ifPresent(cnhCategoria ->   {
                        admission.setCnhCategoriaCodigo(cnhCategoria.getCodigo());
                        admission.setCnhCategoriaNome(cnhCategoria.getNome());
                    });

                    Optional.ofNullable(cnh.getEstado()).ifPresent(cnhEstado ->   {
                        admission.setCnhEstadoCodigo(cnhEstado.getCodigo());
                        admission.setCnhEstadoNome(cnhEstado.getNome());
                        admission.setCnhEstadoSigla(cnhEstado.getSigla());
                    });
                });

                Optional.ofNullable(candidato.getDocumentoDeClasse()).ifPresent(documentoDeClasse -> {
                        admission.setDocumentoClasseNumero(documentoDeClasse.getNumero());
                        admission.setDocumentoClasseExpedidoEm(documentoDeClasse.getExpedidoEm());
                        admission.setDocumentoClasseVenceem(documentoDeClasse.getVenceEm());

                        Optional.ofNullable(documentoDeClasse.getCidade()).ifPresent(cidade ->   {
                            admission.setDocumentoClasseCidadeCodigo(cidade.getCodigo());
                            admission.setDocumentoClasseCidadeNome(cidade.getNome());
                        });

                        Optional.ofNullable(documentoDeClasse.getEstado()).ifPresent(estado ->   {
                            admission.setDocumentoClasseEstadoCodigo(estado.getCodigo());
                            admission.setDocumentoClasseEstadoNome(estado.getNome());
                            admission.setDocumentoClasseEstadoSigla(estado.getSigla());
                        });

                        Optional.ofNullable(documentoDeClasse.getOrgaoEmissor()).ifPresent(orgaoEmissor ->   {
                            admission.setDocumentoClasseOrgaoEmissorNome(orgaoEmissor.getNome());
                            admission.setDocumentoClasseOrgaoEmissorCodigo(orgaoEmissor.getCodigo());
                        });

                        Optional.ofNullable(documentoDeClasse.getTipo()).ifPresent(tipo ->   {
                            admission.setDocumentoClasseTipoCodigo(tipo.getCodigo());
                            admission.setDocumentoClasseTipoNome(tipo.getNome());
                        });
                });

                Optional.ofNullable(candidato.getNacionalidade()).ifPresent(nacionalidade ->   {
                    admission.setNacionalidadeCodigo(nacionalidade.getCodigo());
                    admission.setNacionalidadeNome(nacionalidade.getNome());
                    admission.setNacionalidadeSigla(nacionalidade.getSigla());
                });

                Optional.ofNullable(candidato.getNaturalidade()).ifPresent(naturalidade -> {
                    Optional.ofNullable(naturalidade.getCidade()).ifPresent(cidade ->   {
                        admission.setNaturalidadeCidadeCodigo(cidade.getCodigo());
                        admission.setNaturalidadeCidadeNome(cidade.getNome());
                    });

                    Optional.ofNullable(naturalidade.getEstado()).ifPresent(estado ->   {
                        admission.setNaturalidadeEstadoCodigo(estado.getCodigo());
                        admission.setNaturalidadeEstadoNome(estado.getNome());
                        admission.setNaturalidadeEstadoSigla(estado.getSigla());
                    });
                });

                Optional.ofNullable(candidato.getOrientacaoSexual()).ifPresent(orientacaoSexual -> {
                    admission.setOrientacaoSexualCodigo(orientacaoSexual.getCodigo());
                    admission.setOrientacaoSexualNome(orientacaoSexual.getNome());
                });

                Optional.ofNullable(candidato.getPis()).ifPresent(pis -> {
                    admission.setPis(pis.getNumero());
                });

                Optional.ofNullable(candidato.getRaca()).ifPresent(raca -> {
                    admission.setRacaCodigo(raca.getCodigo());
                    admission.setRacaNome(raca.getNome());
                });

                Optional.ofNullable(candidato.getSexo()).ifPresent(sexo -> {
                    admission.setSexoCodigo(sexo.getCodigo());
                    admission.setSexoNome(sexo.getNome());
                });

                Optional.ofNullable(candidato.getCtps()).ifPresent(ctps -> {
                    admission.setCtpsNumero(ctps.getNumero());
                    admission.setCtpsSerie(ctps.getSerie());
                    admission.setCtpsEmitidaEm(ctps.getEmitidaEm());
                    admission.setCtpsRecebeuSeguroDesemprego(String.valueOf(ctps.getRecebeSeguroDesemprego()));
                    admission.setCtpsVenceEm(ctps.getVenceEm());

                    Optional.ofNullable(ctps.getEstado()).ifPresent(estado ->   {
                        admission.setCtpsEstadoCodigo(estado.getCodigo());
                        admission.setCtpsEstadoNome(estado.getNome());
                        admission.setCtpsEstadoSigla(estado.getSigla());
                    });

                    Optional.ofNullable(ctps.getAposentadoria()).ifPresent(aposentadoria -> {
                        admission.setCtpsAposentadoriaAposentouEm(aposentadoria.getAposentouEm());
                        admission.setCtpsAposentadoriaNumeroBeneficio(aposentadoria.getNumeroDoBeneficio());
                    });
                });

                Optional.ofNullable(candidato.getRg()).ifPresent(rg -> {
                    admission.setRgNumero(rg.getNumero());
                    admission.setRgExpedidoEm(rg.getExpedidoEm());
                    admission.setRgOrgaoEmissor(rg.getOrgaoEmissor());

                    Optional.ofNullable(rg.getEstado()).ifPresent(estado -> {
                        admission.setRgEstadoCodigo(estado.getCodigo());
                        admission.setRgEstadoNome(estado.getNome());
                        admission.setRgEstadoSigla(estado.getSigla());
                    });
                });

                Optional.ofNullable(candidato.getTituloEleitor()).ifPresent(titulo -> {
                    admission.setTituloEleitorNumero(titulo.getNumero());
                    admission.setTituloEleitorZona(titulo.getZona());
                    admission.setTituloEleitorSecao(titulo.getSecao());
                    admission.setTituloEleitorEmitidoEm(titulo.getEmitidoEm());

                    Optional.ofNullable(titulo.getEstado()).ifPresent(estado -> {
                        admission.setTituloEleitorEstadoCodigo(estado.getCodigo());
                        admission.setTituloEleitorEstadoNome(estado.getNome());
                        admission.setTituloEleitorEstadoSigla(estado.getSigla());
                    });

                    Optional.ofNullable(titulo.getCidade()).ifPresent(cidade -> {
                        admission.setTituloEleitorCidadeCodigo(cidade.getCodigo());
                        admission.setTituloEleitorCidadeNome(cidade.getNome());
                    });
                });

                Optional.ofNullable(candidato.getReservista()).ifPresent(reservista -> {
                    admission.setReservistaNumero(reservista.getNumero());
                    admission.setReservistaRa(reservista.getRa());
                    admission.setReservistaSerie(reservista.getSerie());
                });

                Optional.ofNullable(candidato.getTipoDeficiencia()).ifPresent(tipoDeficiencia -> {
                    admission.setTipoDeficienciaCodigo(tipoDeficiencia.getCodigo());
                    admission.setTipoDeficienciaNome(tipoDeficiencia.getNome());
                });

                return admission;

        } catch (Exception e) {
            logger.error("====> parseCandidato - Exception: " + candidato.get_id() + " -> " + e.getMessage());
            throw new Exception("====> parseCandidato - Exception: " + e.getMessage());
        }

    }

}
