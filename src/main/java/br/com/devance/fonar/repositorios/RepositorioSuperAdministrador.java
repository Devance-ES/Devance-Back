package br.com.devance.fonar.repositorios;

import java.util.Optional;

public interface RepositorioSuperAdministrador {
    Optional<Object> findById(Long idSuperAdminExecutor);
}
