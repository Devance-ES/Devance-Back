package br.com.devance.fonar.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOEntradaFonar {

    @NotBlank(message = "O CPF da vítima é obrigatório.")
    private String cpfVitima;

    @Valid // Valida os campos dentro de DTOIdentificacaoPartesFonar
    @NotNull(message = "O bloco de identificação das partes não pode ser nulo.")
    private DTOIdentificacaoPartesFonar identificacaoPartes;

    @Valid // Valida os campos dentro de DTOHistoricoViolenciaFonar
    @NotNull(message = "O bloco de histórico de violência não pode ser nulo.")
    private DTOHistoricoViolenciaFonar blocoI_HistoricoViolencia;

    @Valid // Valida os campos dentro de DTOSobreAgressorFonar
    @NotNull(message = "O bloco sobre o agressor não pode ser nulo.")
    private DTOSobreAgressorFonar blocoII_SobreAgressor;

    @Valid // Valida os campos dentro de DTOSobreVitimaFonar
    @NotNull(message = "O bloco sobre a vítima não pode ser nulo.")
    private DTOSobreVitimaFonar blocoIII_SobreVitima;

    @Valid // Valida os campos dentro de DTOOutrasInformacoesFonar
    @NotNull(message = "O bloco de outras informações não pode ser nulo.")
    private DTOOutrasInformacoesFonar blocoIV_OutrasInformacoes;

    @Valid // Valida os campos dentro de DTOPreenchimentoProfissionalFonar
    @NotNull(message = "O bloco de preenchimento profissional não pode ser nulo.")
    private DTOPreenchimentoProfissionalFonar preenchimentoProfissional;
}

