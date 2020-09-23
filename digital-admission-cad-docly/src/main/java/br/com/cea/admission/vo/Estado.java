package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estado {

    @Column(name="codigo")
    private Integer codigo;
    @Column(name="nome")
    private String nome;
    @Column(name="sigla")
    private String sigla;
}
