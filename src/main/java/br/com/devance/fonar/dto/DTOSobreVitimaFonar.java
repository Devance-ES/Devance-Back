package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.CorRaca;
import br.com.devance.fonar.enums.FaixaEtariaFilhos;
import br.com.devance.fonar.enums.SituacaoFilhos;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOSobreVitimaFonar {

    @NotNull(message = "A informação sobre tentativa de separação é obrigatória.")
    private Boolean tentouSeparar;

    @NotNull(message = "A situação dos filhos é obrigatória.")
    private SituacaoFilhos situacaoFilhos;

    @Min(value = 0, message = "A quantidade de filhos com o agressor não pode ser negativa.")
    private Integer qtdFilhosComAgressor;

    @Min(value = 0, message = "A quantidade de filhos de outro relacionamento não pode ser negativa.")
    private Integer qtdFilhosDeOutroRelacionamento;

    @NotEmpty(message = "A lista de faixas etárias dos filhos não pode ser vazia.")
    @NotNull(message = "As faixas etárias dos filhos são obrigatórias.")
    private List<FaixaEtariaFilhos> faixaEtariaFilhos;

    @NotNull(message = "A informação sobre filhos deficientes é obrigatória.")
    private Boolean temFilhosDeficientes;

    @Min(value = 0, message = "A quantidade de filhos com deficiência não pode ser negativa.")
    private int qtdFilhosDeficiencia;

    @NotNull(message = "A informação sobre conflito de guarda é obrigatória.")
    private Boolean conflitoDeGuarda;

    @NotNull(message = "A informação sobre filhos presenciarem violência é obrigatória.")
    private Boolean filhosViramViolencia;

    @NotNull(message = "A informação sobre violência na gravidez/pós-parto é obrigatória.")
    private Boolean violenciaGravidezPosParto;

    @NotNull(message = "A informação sobre aumento de violência em novo relacionamento é obrigatória.")
    private Boolean novoRelAumentaViolencia;

    @NotNull(message = "A informação sobre deficiência da vítima é obrigatória.")
    private Boolean possuiDeficiencia;

    // Validação condicional pode ser feita no Service se necessário
    private String qualDeficiencia;

    @NotNull(message = "A cor/raça da vítima é obrigatória.")
    private CorRaca corRaca;
}
