package br.com.cea.admission.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {

    private String nome;
    private String imagem;
    private String colaboradorId;
    private String extensao;
    private String clientId;

}
