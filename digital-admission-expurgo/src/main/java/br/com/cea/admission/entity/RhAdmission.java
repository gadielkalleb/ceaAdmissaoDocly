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
@Table(name="RH024T_ADMI_DIGITAL")
public class RhAdmission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="PREADMISSAOID")
    private String preAdmissaoId;
    @Column(name="CARGO")
    private String cargo;
    @Column(name="SALARIO")
    private String salario;
    @Column(name="NOME")
    private String nome;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CELULAR")
    private String celular;
    @Column(name="CEP")
    private String cep;
    @Column(name="LOGRADOURO")
    private String logradouro;
    @Column(name="NUMERO")
    private String numero;
    @Column(name="COMPLEMENTO")
    private String complemento;
    @Column(name="BAIRRO")
    private String bairro;
    @Column(name="CIDADE_CODIGO")
    private String codigoCidade;
    @Column(name="CIDADE_NOME")
    private String nomeCidade;
    @Column(name="ESTADO_CODIGO")
    private String codigoEstado;
    @Column(name="ESTADO_NOME")
    private String nomeEstado;
    @Column(name="ESTADO_SIGLA")
    private String siglaEstado;
    @Column(name="ADMISSAOPREVISTAPARA")
    private String dataAdmissao;
    @Column(name="DURACAODOCONTRATOEMDIAS")
    private String tempoContrato;
    @Column(name="MATRICULA")
    private String matricula;
    @Column(name="STATUS")
    private String status;
    @Column(name="DATA_STATUS")
    private String dataStatus;
    @Column(name="ID_ADMISSAO_DOCLY")
    private String idAdmissaoDocley;
    @Column(name="CPF")
    private String cpf;
}
