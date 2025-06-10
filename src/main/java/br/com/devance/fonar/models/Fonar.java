package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status;

import java.time.LocalDate;
import java.util.UUID;

public class Fonar {

    private UUID idFonar;
    private Delegacia delegacia;
    private LocalDate dataRegistro;
    private String responsavel;


    private IdentificacaoPartesFONAR identificacaoPartes; // Bloco de identificação das partes (vítima/agressor)
    private HistoricoViolenciaFONAR blocoI_HistoricoViolencia; // Bloco I: Histórico de Violência
    private SobreAgressorFONAR blocoII_SobreAgressor; // Bloco II: Informações sobre o Agressor
    private SobreVitimaFONAR blocoIII_SobreVitima; // Bloco III: Informações sobre a Vítima (aspectos de vulnerabilidade)
    private OutrasInformacoesFONAR blocoIV_OutrasInformacoes; // Bloco IV: Outras informações relevantes
    private PreenchimentoProfissionalFONAR preenchimentoProfissional; // Bloco de preenchimento feito pelo profissional
    private String grauDeRiscoCalculado;

    private Enum<Status> statusTriagem; // Status atual da triagem (String ou Enum)
    private String caminhoImagemOriginal; // Caminho para imagem de FONARs físicos


    public Fonar(UUID idFonar, Delegacia delegacia, LocalDate dataRegistro, String responsavel,
                 IdentificacaoPartesFONAR identificacaoPartes, HistoricoViolenciaFONAR blocoI_HistoricoViolencia,
                 SobreAgressorFONAR blocoII_SobreAgressor, SobreVitimaFONAR blocoIII_SobreVitima,
                 OutrasInformacoesFONAR blocoIV_OutrasInformacoes, PreenchimentoProfissionalFONAR preenchimentoProfissional,
                 String grauDeRiscoCalculado)
    {
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
        this.statusTriagem = statusTriagem;
    }

    public String getCaminhoImagemOriginal() {
        return caminhoImagemOriginal;
    }

    public void setCaminhoImagemOriginal(String caminhoImagemOriginal) {
        this.caminhoImagemOriginal = caminhoImagemOriginal;
    }


}
