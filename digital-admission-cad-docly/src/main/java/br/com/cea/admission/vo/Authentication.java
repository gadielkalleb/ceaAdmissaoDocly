package br.com.cea.admission.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Authentication {

    private String nome;
    private String email;
    private String perfil;
    private String token;
    private Boolean primeiroAcesso;
    private String clienteId;
}
