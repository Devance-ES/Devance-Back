package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.enums.Cargo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioFuncionarioSecundario extends JpaRepository<FuncionarioSecundario, Long> {
    Optional<FuncionarioSecundario> findByCpf(String cpf); // UC-012
    boolean existsByCpf(String cpf); // UC-012
    List<FuncionarioSecundario> findByDelegacia(Delegacia delegacia); // Para listar funcionários de uma delegacia
    List<FuncionarioSecundario> findByDelegaciaAndCargo(Delegacia delegacia, Cargo cargo);
    List<FuncionarioSecundario> findByAtivoTrueAndDelegacia(Delegacia delegacia); // Para listar ativos (UC-028)
}