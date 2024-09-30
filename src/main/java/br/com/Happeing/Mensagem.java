package br.com.Happeing;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvio;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Usuario destinatario;

    @ManyToOne
    @JoinColumn(name = "grupo_mensagem_id")
    private GrupoMensagem grupoMensagem;

    public Mensagem(String conteudo, Date dataEnvio, Usuario remetente, Usuario destinatario) {
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

}
