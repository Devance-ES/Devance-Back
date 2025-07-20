package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.FonarOCR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFonarOCR extends JpaRepository<FonarOCR, Long> {

}
