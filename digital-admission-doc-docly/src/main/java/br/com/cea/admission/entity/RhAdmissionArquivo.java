package br.com.cea.admission.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="RH024T_ADMI_DIGITAL_ARQUIVO")
public class RhAdmissionArquivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="CPF")
    private String cpf;

    @Column(name="SEQUENCIA")
    private Integer sequencia;

    @Lob
    @Column(name="CAA_CONTEUDO")
    private byte[] conteudo;

    @Column(name="CAA_NOMEARQUIVO")
    private String nome;

    @Column(name="STATUS")
    private String status;

}
