package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.enums.StatusDelegacia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioDelegacia extends JpaRepository<Delegacia, Long>, JpaSpecificationExecutor<Delegacia> {
    Optional<Delegacia> findByCnpj(String cnpj); // UC-005, UC-006, UC-008
    boolean existsByCnpj(String cnpj); // UC-005
    List<Delegacia> findByStatus(StatusDelegacia status); // UC-006, UC-010
    List<Delegacia> findByTipo(String tipo);
    Optional<Delegacia> findByNome(String nome);
    List<Delegacia> findByNomeContainingIgnoreCase(String nome);
    List<Delegacia> findAllByOrderByNomeAsc(); // UC-010
    Optional<Delegacia> findByCnpjAndSenha(String cnpj, String senha); // UC-011 (login da instituição)
}