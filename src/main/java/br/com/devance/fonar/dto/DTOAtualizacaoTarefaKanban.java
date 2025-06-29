package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status; // Status da TarefaTriagem
import br.com.devance.fonar.enums.PrioridadeTarefas; // Prioridade da TarefaTriagem
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID; // Para referenciar ID da Tarefa

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAtualizacaoTarefaKanban {
    // Campos para Adicionar Item (se for criação manual não vinculada a FONAR)
    private UUID idFonarAssociado; // Pode ser nulo se a tarefa não for vinculada a um FONAR existente
    private String tituloTarefa; // Se for uma tarefa avulsa
    private String descricao;
    private PrioridadeTarefas prioridade;
    private Long idResponsavel; // ID do funcionário responsável pela tarefa

    @NotNull(message = "O novo status da tarefa é obrigatório.")
    private Status novoStatus;

    @NotBlank(message = "Um comentário para a atualização da tarefa é obrigatório.")
    private String comentario;

    private LocalDateTime dataAtualizacao; // Pode ser definido no backend

    // Prazo da tarefa (opcional)
    private LocalDate prazo;
}