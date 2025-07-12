package br.com.devance.fonar.dto; // Ou br.com.devance.fonar.dtos.filtro, se preferir um pacote separado para DTOs de filtro

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera construtor sem argumentos
@AllArgsConstructor // Gera construtor com todos os argumentos
@Builder // Gera o padrão Builder
public class DTOFiltroFonar {
    private String textoBusca; // Campo para busca de texto completo em vários atributos do FONAR
    private String ordenarPor;    // Nome do campo pelo qual os resultados serão ordenados (ex: "dataRegistro", "grauDeRiscoCalculado")
    private String direcao;  // Direção da ordenação (ex: "ASC", "DESC")
}