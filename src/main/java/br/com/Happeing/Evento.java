package br.com.Happeing;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "eventos")

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String local;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador;

    @ManyToMany
    @JoinTable(
            name = "evento_participantes",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> participantes;


}
