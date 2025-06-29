package br.com.devance.fonar.repositorios;

// IMPORTANTE: Remova org.springframework.beans.factory.annotation.Autowired se estiver lá.
// Remova org.springframework.stereotype.Repository se estiver lá.
// Eles não são necessários para interfaces de repositório Spring Data.

import br.com.devance.fonar.models.SuperAdministrador; // Importe sua classe de entidade SuperAdministrador
import org.springframework.data.jpa.repository.JpaRepository; // Importe JpaRepository

import java.util.Optional; // Importe Optional se ainda não estiver

// Esta interface deve estender JpaRepository
// JpaRepository<[Sua Entidade], [Tipo do ID da Entidade]>
public interface RepositorioSuperAdministrador extends JpaRepository<SuperAdministrador, Long> {

    // O Spring Data JPA já fornece findById.
    // Se você precisar de findById, ele já está disponível sem precisar declará-lo aqui.
    // Mas se você quiser um método personalizado, ele deve retornar a entidade correta.
    // Exemplo:
    // Optional<SuperAdministrador> findByEmail(String email);
}