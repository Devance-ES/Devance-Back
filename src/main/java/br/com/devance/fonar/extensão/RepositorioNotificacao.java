package br.com.devance.fonar.extensão;

import br.com.devance.fonar.extensão.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioNotificacao extends JpaRepository<Notificacao, UUID> {
    // Métodos de consulta adicionais podem ser inseridos aqui, se necessário.
    // Por exemplo: List<Notificacao> findByResponsavel(Usuario responsavel);
}
