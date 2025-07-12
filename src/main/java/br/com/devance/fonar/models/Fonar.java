package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fonars")
public class Fonar {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFonar;

    @Setter
    @Getter
    @Column
    private String cpfVitima;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "delegacia_id", nullable = false)
    private Delegacia delegacia;

    @Setter
    @Getter
    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Setter
    @Getter
    @Column(name = "responsavel_registro", length = 255)
    private String responsavel;

    @Setter
    @Getter
    @Embedded
    private IdentificacaoPartesFONAR identificacaoPartes;

    @Setter
    @Getter
    @Embedded
    private HistoricoViolenciaFONAR blocoI_HistoricoViolencia;

    @Setter
    @Getter
    @Embedded
    private SobreAgressorFONAR blocoII_SobreAgressor;

    @Setter
    @Getter
    @Embedded
    private SobreVitimaFONAR blocoIII_SobreVitima;

    @Setter
    @Getter
    @Embedded
    private OutrasInformacoesFONAR blocoIV_OutrasInformacoes;

    @Setter
    @Getter
    @Embedded
    private PreenchimentoProfissionalFONAR preenchimentoProfissional;

    @Setter
    @Getter
    @Column(name = "grau_risco_calculado", length = 50)
    private String grauDeRiscoCalculado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_triagem", nullable = false, length = 50)
    private Status statusTriagem;

    @Setter
    @Getter
    @Column(name = "caminho_imagem_original", length = 500)
    private String caminhoImagemOriginal;

    public Enum<Status> getStatusTriagem() {
        return statusTriagem;
    }

    public void setStatusTriagem(Enum<Status> statusTriagem) {
        this.statusTriagem = (Status) statusTriagem;
    }

}