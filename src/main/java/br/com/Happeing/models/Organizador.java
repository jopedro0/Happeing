package br.com.Happeing.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Entity

public class Organizador {
    @Id
    private String cnpj;
    private String nome;
    private String email;
    private String telefone;

}
