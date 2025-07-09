package br.com.devance.fonar.servicos;

import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.enums.Status; // Enum para status da tarefa
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.TarefaTriagem;

import br.com.devance.fonar.repositorios.RepositorioDelegacia;
import br.com.devance.fonar.repositorios.RepositorioTarefaTriagem;
import br.com.devance.fonar.repositorios.RepositorioFonar; // Para buscar o FONAR associado


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Para operações transacionais

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServicoGerenciamentoTarefas {

    @Autowired
    private RepositorioTarefaTriagem repositorioTarefaTriagem;
    @Autowired
    private RepositorioFonar repositorioFonar; // Necessário para criar Tarefa a partir de um Fonar
    @Autowired
    private RepositorioDelegacia repositorioDelegacia;


    // UC17/UC26 - Obter Dados para Painel Kanban da Delegacia
    public Map<String, List<TarefaTriagem>> obterDadosKanbanDelegacia(Long idDelegacia) {
        List<TarefaTriagem> tarefas = repositorioTarefaTriagem.findByDelegaciaId(idDelegacia);

        return tarefas.stream()
                .collect(Collectors.groupingBy(tarefa -> tarefa.getStatus().toString()));
    }

    // Método para criar uma nova tarefa de triagem (chamado por ServicoFonar)
    @Transactional
    public TarefaTriagem criarNovaTarefaTriagem(UUID idFonar, String grauRiscoFonar, String CNPJDelegacia, Long idUsuarioCriador) {
        Fonar fonar = repositorioFonar.findById(idFonar)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("FONAR não encontrado com ID: " + idFonar));


        Delegacia delegacia = repositorioDelegacia.findByCnpj(CNPJDelegacia).orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        TarefaTriagem novaTarefa = new TarefaTriagem();
        novaTarefa.setFonar(fonar);
        novaTarefa.setDelegacia(fonar.getDelegacia()); // Vincula à delegacia do FONAR
        novaTarefa.setDataCriacao(LocalDateTime.now());
        novaTarefa.setStatus(Status.CRIADA); // Status inicial da tarefa
        novaTarefa.setObservacoes("Tarefa criada automaticamente para triagem do FONAR.");// Assumindo PrioridadeTarefa como atributo
        novaTarefa.setDelegacia(delegacia);

        TarefaTriagem tarefaSalva = repositorioTarefaTriagem.save(novaTarefa);

        return tarefaSalva;
    }

    // Método para atualizar o status de uma tarefa
    @Transactional
    public TarefaTriagem atualizarStatusTarefa(UUID tarefaId, Status novoStatus, String comentario, Long idUsuarioAtualizador) {
        TarefaTriagem tarefa = repositorioTarefaTriagem.findById(tarefaId)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Tarefa não encontrada com ID: " + tarefaId));

        tarefa.setStatus(novoStatus);
        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setObservacoes(tarefa.getObservacoes() + "\n" + LocalDateTime.now() + " - " + comentario); // Adiciona novo comentário

        TarefaTriagem tarefaAtualizada = repositorioTarefaTriagem.save(tarefa);

        return tarefaAtualizada;
    }

    // UC23 - Remover Colaborador (lógica de impacto nas tarefas)
    @Transactional
    public void desvincularTarefasDoColaborador(Long idFuncionarioRemovido, Long idUsuarioRemovedor) {
        List<TarefaTriagem> tarefasDoFuncionario = repositorioTarefaTriagem.findByResponsavelId(idFuncionarioRemovido);

        for (TarefaTriagem tarefa : tarefasDoFuncionario) {
            if (tarefa.getStatus() != Status.FINALIZADA) {
                tarefa.setResponsavel(null); // Desvincula o responsável
                tarefa.setStatus(Status.EM_ATENDIMENTO); // Novo status: aguardando nova atribuição
                tarefa.setDataCriacao(LocalDateTime.now());
                tarefa.setObservacoes(tarefa.getObservacoes() + "\n" + LocalDateTime.now() + " - Responsável removido, tarefa pendente de nova atribuição.");
                repositorioTarefaTriagem.save(tarefa);
            }
        }
    }

    // Método para obter uma tarefa por ID
    public TarefaTriagem obterTarefaPorId(UUID idTarefa) {
        return repositorioTarefaTriagem.findById(idTarefa)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Tarefa não encontrada com ID: " + idTarefa));
    }
}