package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Delegacia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioDelegacia extends JpaRepository<Delegacia, Long>, JpaSpecificationExecutor<Delegacia> {

    Optional<Delegacia> findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);

    Optional<Delegacia> findByNome(String nome);

    List<Delegacia> findByNomeContainingIgnoreCase(String nome);

    List<Delegacia> findAllByOrderByNomeAsc();

    Optional<Delegacia> findByCnpjAndSenha(String cnpj, String senha);
}