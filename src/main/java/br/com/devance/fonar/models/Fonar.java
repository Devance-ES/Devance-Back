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
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Version;

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
    @JoinColumn(name = "delegacia_id", nullable = true)
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

    @Version
    @Getter
    @Setter
    private Long version;

    // NOVOS ATRIBUTOS PARA AVALIAÇÃO DE RISCO
    private String risco;
    private Double pontuacaoRisco;

    public Fonar() {
        this.dataRegistro = LocalDate.now();
    }

    public Enum<Status> getStatusTriagem() {
        return statusTriagem;
    }

    public String getCpfVitima() {
        return cpfVitima;
    }

    // Métodos getters e setters para os novos atributos
    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Double getPontuacaoRisco() {
        return pontuacaoRisco;
    }

    public void setPontuacaoRisco(Double pontuacaoRisco) {
        this.pontuacaoRisco = pontuacaoRisco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public IdentificacaoPartesFONAR getIdentificacaoPartes() {
        return identificacaoPartes;
    }

    public HistoricoViolenciaFONAR getBlocoI_HistoricoViolencia() {
        return blocoI_HistoricoViolencia;
    }

    public SobreAgressorFONAR getBlocoII_SobreAgressor() {
        return blocoII_SobreAgressor;
    }

    public SobreVitimaFONAR getBlocoIII_SobreVitima() {
        return blocoIII_SobreVitima;
    }

    public OutrasInformacoesFONAR getBlocoIV_OutrasInformacoes() {
        return blocoIV_OutrasInformacoes;
    }

    public PreenchimentoProfissionalFONAR getPreenchimentoProfissional() {
        return preenchimentoProfissional;
    }

    public String getCaminhoImagemOriginal() {
        return caminhoImagemOriginal;
    }

    public Long getVersion() {
        return version;
    }

    public void setStatusTriagem(Enum<Status> statusTriagem) {
        this.statusTriagem = (Status) statusTriagem;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public String getGrauDeRiscoCalculado() {
        return grauDeRiscoCalculado;
    }

    public UUID getIdFonar() {
        return idFonar;
    }
}