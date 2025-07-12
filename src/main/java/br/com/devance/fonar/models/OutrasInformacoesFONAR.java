package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.RespostasSimNaoNaoSei;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class OutrasInformacoesFONAR {

    @Enumerated(EnumType.STRING)
    @Column(name = "mora_em_local_de_risco")
    private RespostasSimNaoNaoSei moraEmLocalDeRisco;

    @Column(name = "dependencia_financeira_agressor")
    private boolean dependenciaFinanceiraAgressor;

    @Column(name = "quer_abrigo_temporario")
    private boolean querAbrigoTemporario;
}