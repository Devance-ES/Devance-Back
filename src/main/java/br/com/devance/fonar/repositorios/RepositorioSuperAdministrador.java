package br.com.devance.fonar.repositorios;

import br.com.devance.fonar.models.SuperAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional; // Importe Optional se ainda não estiver

public interface RepositorioSuperAdministrador extends JpaRepository<SuperAdministrador, Long> {

    // O Spring Data JPA já fornece findById.
    // Se você precisar de findById, ele já está disponível sem precisar declará-lo aqui.
    // Mas se você quiser um método personalizado, ele deve retornar a entidade correta.
    // Exemplo:
    // Optional<SuperAdministrador> findByEmail(String email);
}