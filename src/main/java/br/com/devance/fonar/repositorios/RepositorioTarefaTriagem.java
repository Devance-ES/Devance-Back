package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.TarefaTriagem;
import br.com.devance.fonar.enums.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositorioTarefaTriagem extends JpaRepository<TarefaTriagem, UUID>, JpaSpecificationExecutor<TarefaTriagem> {

    // Métodos para o Kanban e gerenciamento de tarefas
    List<TarefaTriagem> findByDelegaciaId(Long delegaciaId);

    List<TarefaTriagem> findByDelegaciaIdAndStatus(Long delegaciaId, Status status);

    // Para buscar tarefas atribuídas a um responsável específico (UC23 - Remover colaborador)
    List<TarefaTriagem> findByResponsavelId(Long responsavelId);

    // Para buscar tarefas relacionadas a um FONAR específico
    Optional<TarefaTriagem> findByFonarIdFonar(UUID fonarId);

    // Para contagens e estatísticas de tarefas
    long countByStatus(Status status);

    long countByDelegaciaIdAndStatus(Long delegaciaId, Status status);

    // Verifica se uma tarefa existe com base no FONAR associado e um status
    boolean existsByFonarIdFonarAndStatus(UUID fonarId, Status status);
}