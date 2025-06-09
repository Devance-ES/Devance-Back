package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class TarefaTriagem {
    private UUID idTarefa;
    private Fonar fonar;
    private Delegacia delegacia;
    private Usuario responsavel;
    private LocalDateTime dataCriacao;
    private Status status;
    private String observacoes;


    public TarefaTriagem() {
    }

    public TarefaTriagem(UUID id,Fonar fonar, Delegacia delegacia, Usuario usuario, LocalDateTime data, String observacoes){
        this.idTarefa=id;
        this.fonar=fonar;
        this.delegacia=delegacia;
        this.responsavel=usuario;
        this.dataCriacao=data;
        this.observacoes=observacoes;

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

    public void  alterarStatus(Status status){}

    public void alterarResponsavel(Usuario usuario){}

    public void adicionarObservação(){}


}
