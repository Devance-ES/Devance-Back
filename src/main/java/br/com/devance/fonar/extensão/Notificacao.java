package br.com.devance.fonar.extensão;

import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notificacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idNotificacao;

    @Column(name = "mensagem", nullable = false, length = 500)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "fonar_id", nullable = false)
    private Fonar fonar;

    // O responsável será nulo, já que não temos um serviço de usuário para atribuir.
    // Esta coluna será usada futuramente para associar a notificação a um delegado.
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "lida")
    private boolean lida;

    public void setIdNotificacao(UUID idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setFonar(Fonar fonar) {
        this.fonar = fonar;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
}