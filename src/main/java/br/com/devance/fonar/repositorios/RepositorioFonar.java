package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Fonar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositorioFonar extends JpaRepository<Fonar, UUID>, JpaSpecificationExecutor<Fonar>

{
    List<Fonar> findByCpfVitima(String cpfVitima);

    Optional<Fonar> findByIdFonarAndCpfVitima(UUID idFonar, String cpfVitima);
}