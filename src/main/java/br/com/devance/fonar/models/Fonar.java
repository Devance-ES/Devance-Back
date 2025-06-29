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
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fonars")
public class Fonar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFonar;

    @Column
    private String cpfVitima;

    @ManyToOne
    @JoinColumn(name = "delegacia_id", nullable = false)
    private Delegacia delegacia;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "responsavel_registro", length = 255)
    private String responsavel;

    @Embedded
    private IdentificacaoPartesFONAR identificacaoPartes;

    @Embedded
    private HistoricoViolenciaFONAR blocoI_HistoricoViolencia;

    @Embedded
    private SobreAgressorFONAR blocoII_SobreAgressor;

    @Embedded
    private SobreVitimaFONAR blocoIII_SobreVitima;

    @Embedded
    private OutrasInformacoesFONAR blocoIV_OutrasInformacoes;

    @Embedded
    private PreenchimentoProfissionalFONAR preenchimentoProfissional;

    @Column(name = "grau_risco_calculado", length = 50)
    private String grauDeRiscoCalculado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_triagem", nullable = false, length = 50)
    private Status statusTriagem;

    @Column(name = "caminho_imagem_original", length = 500)
    private String caminhoImagemOriginal;


    public Fonar() {
        this.idFonar = UUID.randomUUID();
        this.dataRegistro = LocalDate.now();
    }


    public Fonar(UUID idFonar,String cpfVitima, Delegacia delegacia, LocalDate dataRegistro, String responsavel,
                 IdentificacaoPartesFONAR identificacaoPartes, HistoricoViolenciaFONAR blocoI_HistoricoViolencia,
                 SobreAgressorFONAR blocoII_SobreAgressor, SobreVitimaFONAR blocoIII_SobreVitima,
                 OutrasInformacoesFONAR blocoIV_OutrasInformacoes, PreenchimentoProfissionalFONAR preenchimentoProfissional,
                 String grauDeRiscoCalculado)
    {
        this.cpfVitima = cpfVitima;
        this.idFonar = idFonar;
        this.delegacia = delegacia;
        this.dataRegistro = dataRegistro;
        this.responsavel = responsavel;
        this.identificacaoPartes = identificacaoPartes;
        this.blocoI_HistoricoViolencia = blocoI_HistoricoViolencia;
        this.blocoII_SobreAgressor = blocoII_SobreAgressor;
        this.blocoIII_SobreVitima = blocoIII_SobreVitima;
        this.blocoIV_OutrasInformacoes = blocoIV_OutrasInformacoes;
        this.preenchimentoProfissional = preenchimentoProfissional;
        this.grauDeRiscoCalculado = grauDeRiscoCalculado;
    }




    public UUID getIdFonar() {
        return idFonar;
    }

    public void setIdFonar(UUID idFonar) {
        this.idFonar = idFonar;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public IdentificacaoPartesFONAR getIdentificacaoPartes() {
        return identificacaoPartes;
    }

    public void setIdentificacaoPartes(IdentificacaoPartesFONAR identificacaoPartes) {
        this.identificacaoPartes = identificacaoPartes;
    }

    public HistoricoViolenciaFONAR getBlocoI_HistoricoViolencia() {
        return blocoI_HistoricoViolencia;
    }

    public void setBlocoI_HistoricoViolencia(HistoricoViolenciaFONAR blocoI_HistoricoViolencia) {
        this.blocoI_HistoricoViolencia = blocoI_HistoricoViolencia;
    }

    public SobreAgressorFONAR getBlocoII_SobreAgressor() {
        return blocoII_SobreAgressor;
    }

    public void setBlocoII_SobreAgressor(SobreAgressorFONAR blocoII_SobreAgressor) {
        this.blocoII_SobreAgressor = blocoII_SobreAgressor;
    }

    public SobreVitimaFONAR getBlocoIII_SobreVitima() {
        return blocoIII_SobreVitima;
    }

    public void setBlocoIII_SobreVitima(SobreVitimaFONAR blocoIII_SobreVitima) {
        this.blocoIII_SobreVitima = blocoIII_SobreVitima;
    }

    public OutrasInformacoesFONAR getBlocoIV_OutrasInformacoes() {
        return blocoIV_OutrasInformacoes;
    }

    public void setBlocoIV_OutrasInformacoes(OutrasInformacoesFONAR blocoIV_OutrasInformacoes) {
        this.blocoIV_OutrasInformacoes = blocoIV_OutrasInformacoes;
    }

    public PreenchimentoProfissionalFONAR getPreenchimentoProfissional() {
        return preenchimentoProfissional;
    }

    public void setPreenchimentoProfissional(PreenchimentoProfissionalFONAR preenchimentoProfissional) {
        this.preenchimentoProfissional = preenchimentoProfissional;
    }

    public String getGrauDeRiscoCalculado() {
        return grauDeRiscoCalculado;
    }

    public void setGrauDeRiscoCalculado(String grauDeRiscoCalculado) {
        this.grauDeRiscoCalculado = grauDeRiscoCalculado;
    }

    public Enum<Status> getStatusTriagem()
    {
        return statusTriagem;
    }

    public void setStatusTriagem(Enum<Status> statusTriagem) {
        this.statusTriagem = (Status) statusTriagem;
    }

    public String getCaminhoImagemOriginal() {
        return caminhoImagemOriginal;
    }

    public void setCaminhoImagemOriginal(String caminhoImagemOriginal) {
        this.caminhoImagemOriginal = caminhoImagemOriginal;
    }

    public String getCpfVitima(){
        return cpfVitima;
    }

    public String setCpfVitima(String cpfVitima){
        return this.cpfVitima = cpfVitima;
    }


}