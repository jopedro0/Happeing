package br.com.Happeing.models;


import jakarta.persistence.Embeddable;

import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;


}
