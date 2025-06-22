package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Vitima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioVitima extends JpaRepository<Vitima, Long>
{
    Optional<Vitima> findByCpf(String cpf);
}