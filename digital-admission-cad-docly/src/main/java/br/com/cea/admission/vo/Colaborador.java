package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Colaborador {

    @Column(name="cargo")
    private String cargo;
    @Column(name="salario")
    private BigDecimal salario;
    @Column(name="nome")
    private String nome;
    @Column(name="email")
    private String email;
    @Column(name="celular")
    private String celular;
    @Column(name="admissaoPrevistaPara")
    private String admissaoPrevistaPara;
    @Column(name="duracaoDoContratoEmDias")
    private Integer duracaoDoContratoEmDias;
    @Column(name="matricula")
    private String matricula;
    private Endereco endereco;
}
