package br.com.devance.fonar.extensão;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioRiscoFonar extends JpaRepository<RiscoFonar, Long> {

    long countByStatusRisco(StatusRisco status);

    List<RiscoFonar> findByCpfAgressor(String cpfAgressor, Sort sort);
}
