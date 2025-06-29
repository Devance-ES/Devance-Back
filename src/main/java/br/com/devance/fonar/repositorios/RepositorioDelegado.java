package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Delegado;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioDelegado extends JpaRepository<Delegado, Long>, JpaSpecificationExecutor<Delegado> {
    Optional<Object> findByCpf(@NotNull(message = "O ID do Delegado responsável é obrigatório.") String cpfDelegado);
}
