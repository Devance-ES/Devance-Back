package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Vitima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioVitima extends JpaRepository<Vitima, Long> {
    Optional<Vitima> findByCpf(String cpf); // UC-001, UC-005
    boolean existsByCpf(String cpf); // UC-005
    Optional<Vitima> findByEmail(String email); // Pode ser usado para login da vítima se o email for um identificador secundário
}