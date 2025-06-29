package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.DoencaMental;
import br.com.devance.fonar.enums.EspecificacaoAmeaca;
import br.com.devance.fonar.enums.RespostasSimNaoNaoSei;
import br.com.devance.fonar.enums.UsoAbusivo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SobreAgressorFONAR {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "uso_abusivo")
    private UsoAbusivo usoAbusivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "doenca_mental")
    private DoencaMental doencaMental;

    @Column(name = "descumpriu_medida_protetiva")
    private Boolean descumpriuMedidaProtetiva;

    @Column(name = "tentou_suicido")
    private Boolean tentouSuicido;

    @Enumerated(EnumType.STRING)
    @Column(name = "dificuldades_financeiras")
    private RespostasSimNaoNaoSei dificuldadesFinanceiras;

    @Enumerated(EnumType.STRING)
    @Column(name = "acesso_armas_fogo")
    private RespostasSimNaoNaoSei acessoArmasFogo;

    @Column(name = "ameacou_ou_agrediu")
    private Boolean ameacouOuAgrediu;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "fonar_ameacas_especificacoes", joinColumns = @JoinColumn(name = "sobre_agressor_id"))
    @Column(name = "especificacao")
    @Enumerated(EnumType.STRING)
    private Set<EspecificacaoAmeaca> especificacaoAmeaca;

}