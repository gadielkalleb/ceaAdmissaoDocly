package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {

    @Column(name="cep")
    private String cep;
    @Column(name="logradouro")
    private String logradouro;
    @Column(name="numero")
    private Integer numero;
    @Column(name="complemento")
    private String complemento;
    @Column(name="bairro")
    private String bairro;

    private Cidade cidade;
    private Estado estado;
}
