package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Escolaridade;
import br.com.devance.fonar.enums.Nacionalidade;
import br.com.devance.fonar.enums.Vinculo;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class IdentificacaoPartesFONAR {

    @Column(name = "vitima_nome", length = 255)
    private String nomeVitima;

    @Column(name = "vitima_idade")
    private int idadeVitima;

    @Enumerated(EnumType.STRING)
    @Column(name = "vitima_escolaridade")
    private Escolaridade escolaridadeVitima;

    @Enumerated(EnumType.STRING)
    @Column(name = "vitima_nacionalidade")
    private Nacionalidade nacionalidadeVitima;

    @Column(name = "agressor_nome", length = 255)
    private String nomeAgressor;

    @Column(name = "agressor_idade")
    private int idadeAgressor;

    @Enumerated(EnumType.STRING)
    @Column(name = "agressor_escolaridade")
    private Escolaridade escolaridadeAgressor;

    @Enumerated(EnumType.STRING)
    @Column(name = "agressor_nacionalidade")
    private Nacionalidade nacionalidadeAgressor;

    @Enumerated(EnumType.STRING)
    @Column(name = "vinculo_entre_partes")
    private Vinculo vinculoEntrePartes;

    @Column(name = "data_ocorrencia")
    private LocalDate dataOcorrencia;
}