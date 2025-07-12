package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.CorRaca;
import br.com.devance.fonar.enums.FaixaEtariaFilhos;

import br.com.devance.fonar.enums.SituacaoFilhos;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class SobreVitimaFONAR {

    @Column(name = "vitima_tentou_separar")
    private Boolean tentouSeparar;

    @Column(name = "vitima_situacao_filhos")
    @Enumerated(EnumType.STRING)
    private SituacaoFilhos situacaoFilhos;

    @Column(name = "vitima_qtd_filhos_com_agressor")
    private Integer qtdFilhosComAgressor;

    @Column(name = "vitima_qtd_filhos_de_outro_relacionamento")
    private Integer qtdFilhosDeOutroRelacionamento;

    @ElementCollection
    @CollectionTable(name = "fonars_vitima_faixa_etaria_filhos", joinColumns = @JoinColumn(name = "fonar_id"))
    @Column(name = "faixa_etaria")
    @Enumerated(EnumType.STRING)
    private List<FaixaEtariaFilhos> faixaEtariaFilhos;

    @Column(name = "vitima_tem_filhos_deficientes")
    private boolean temFilhosDeficientes;

    @Column(name = "vitima_qtd_filhos_deficiencia")
    private int qtdFilhosDeficiencia;


    @Column(name = "vitima_conflito_de_guarda")
    private boolean conflitoDeGuarda;

    @Column(name = "vitima_filhos_viram_violencia")
    private boolean filhosViramViolencia;

    @Column(name = "vitima_violencia_gravidez_pos_parto")
    private boolean violenciaGravidezPosParto;

    @Column(name = "vitima_novo_rel_aumenta_violencia")
    private boolean novoRelAumentaViolencia;

    @Column(name = "vitima_possui_deficiencia")
    private boolean possuiDeficiencia;

    @Column(name = "vitima_qual_deficiencia", length = 255)
    private String qualDeficiencia;

    @Column(name = "vitima_cor_raca")
    @Enumerated(EnumType.STRING)
    private CorRaca corRaca;
}