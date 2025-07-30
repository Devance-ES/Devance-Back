package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Delegado;
import br.com.devance.fonar.models.Delegacia; // Necessário para buscar por delegacia

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioDelegado extends JpaRepository<Delegado, Long>, JpaSpecificationExecutor<Delegado> {

    // Metodo para buscar um Delegado por CPF (UC: Autenticação, Cadastro/Busca)
    Optional<Delegado> findByCpf(String cpf);

    // Metodo para verificar a existência de um Delegado por CPF (UC: Cadastro para evitar duplicidade)
    boolean existsByCpf(String cpf);

    // Metodo para buscar Delegados por Delegacia (UC: Obter Delegados de uma Delegacia)
    List<Delegado> findByDelegacia(Delegacia delegacia);

    // Metodo para buscar Delegado por e-mail (UC: Autenticação, Busca)
    Optional<Delegado> findByEmail(String email);
}