package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.Estatisticas;
import br.com.devance.fonar.models.Usuario; // Para o usuário que gerou a estatística

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Repository
public interface RepositorioEstatisticas extends JpaRepository<Estatisticas, UUID>, JpaSpecificationExecutor<Estatisticas> {

    // UC-024: Acessar página de estatísticas (listar estatísticas já geradas)
    List<Estatisticas> findByGeradoPor(Usuario geradoPor);
    List<Estatisticas> findByGeradoPorId(Long geradoPorId); // Buscar por ID do usuário

    // Para filtrar por período (UC-025)
    List<Estatisticas> findByPeriodoInicioGreaterThanEqualAndPeriodoFimLessThanEqual(LocalDate periodoInicio, LocalDate periodoFim);

    // Para buscar por nome do relatório
    List<Estatisticas> findByNomeRelatorioContainingIgnoreCase(String nomeRelatorio);

}