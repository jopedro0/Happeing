package br.com.Happeing.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Entity

@Table(name = "organizadores")
public class Organizador {
    @Id
    private String cnpj;
    private String nome;
    private String email;
    private String telefone;

}
