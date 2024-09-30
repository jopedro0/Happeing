package br.com.Happeing.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class GrupoMensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToMany
    @JoinTable(
            name = "grupo_mensagem_usuarios",
            joinColumns = @JoinColumn(name = "grupo_mensagem_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;
}
