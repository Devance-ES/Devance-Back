package br.com.devance.fonar.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioSuperAdministrador {
    Optional<Object> findById(Long idSuperAdminExecutor);
}
