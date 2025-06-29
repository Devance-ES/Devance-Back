package br.com.devance.fonar.repositorios;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface RepositorioDelegado {
    Optional<Object> findById(@NotNull(message = "O ID do Delegado responsável é obrigatório.") Long idResponsavel);
}
