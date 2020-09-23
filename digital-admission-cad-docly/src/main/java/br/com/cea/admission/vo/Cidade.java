package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cidade {

     @Column(name="codigo")
     private Long codigo;
     @Column(name="nome")
     private String nome;
}
