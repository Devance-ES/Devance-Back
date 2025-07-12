package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.TipoAgressaoQ2;
import br.com.devance.fonar.enums.TipoAgressaoQ3;
import br.com.devance.fonar.enums.TipoAmeaca;
import br.com.devance.fonar.enums.TipoComportamento;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import lombok.*;

import java.util.Set;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class HistoricoViolenciaFONAR {

    @ElementCollection
    @CollectionTable(name = "fonars_historico_violencia_ameaca", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_ameaca")
    @Enumerated(EnumType.STRING)
    private Set<TipoAmeaca> ameacas;

    @ElementCollection
    @CollectionTable(name = "fonars_hist_violencia_q2", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_agressao_q2")
    @Enumerated(EnumType.STRING)
    private Set<TipoAgressaoQ2> agressoesFisicasQ2;

    @ElementCollection
    @CollectionTable(name = "fonars_hist_violencia_q3", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_agressao_q3")
    @Enumerated(EnumType.STRING)
    private Set<TipoAgressaoQ3> agressoesFisicasQ3;

    private Boolean obrigouSexo;

    @ElementCollection
    @CollectionTable(name = "fonars_hist_violencia_comportamentos", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "tipo_comportamento")
    @Enumerated(EnumType.STRING)
    private Set<TipoComportamento> comportamentos;

    private Boolean jaRegistrouBOAntes;
    private Boolean frequentesRecentemente;
}