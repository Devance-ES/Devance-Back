package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tarefas_triagem")
public class TarefaTriagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTarefa;

    @ManyToOne
    @JoinColumn(name = "fonar_id", nullable = false)
    private Fonar fonar;

    @ManyToOne
    @JoinColumn(name = "delegacia_id", nullable = false)
    private Delegacia delegacia;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public TarefaTriagem() {
    }

    public TarefaTriagem(Fonar fonar, Delegacia delegacia, Usuario usuario, LocalDateTime data, String observacoes) {
        this.fonar = fonar;
        this.delegacia = delegacia;
        this.responsavel = usuario;
        this.dataCriacao = data;
        this.observacoes = observacoes;

    }

    public UUID getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(UUID idTarefa) {
        this.idTarefa = idTarefa;
    }

    public Fonar getFonar() {
        return fonar;
    }

    public void setFonar(Fonar fonar) {
        this.fonar = fonar;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void alterarStatus(Status status) {
    }

    public void alterarResponsavel(Usuario usuario) {
    }

    public void adicionarObservação() {
    }

}