package br.com.Happeing.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    @Column(unique = true)
    private String email;
    @Embedded
    private Endereco endereco;
    @Temporal(TemporalType.DATE)
    private LocalDateTime dataDeNascimento;


}
