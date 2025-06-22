package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Escolaridade;
import br.com.devance.fonar.enums.Nacionalidade;
import br.com.devance.fonar.enums.Vinculo;

import java.time.LocalDate;

public class IdentificacaoPartesFONAR {

    private String nomeVitima;
    private int idadeVitima;
    private Escolaridade escolaridadeVitima;
    private Nacionalidade nacionalidadeVitima;
    private String nomeAgressor;
    private int idadeAgressor;
    private Escolaridade escolaridadeAgressor;
    private Nacionalidade nacionalidadeAgressor;
    private Vinculo vinculoEntrePartes;
    private LocalDate dataOcorrencia;

    public IdentificacaoPartesFONAR(String nomeVitima, int idadeVitima, Escolaridade escolaridadeVitima, Nacionalidade nacionalidadeVitima,
                                    String nomeAgressor, int idadeAgressor, Escolaridade escolaridadeAgressor, Nacionalidade nacionalidadeAgressor,
                                    Vinculo vinculoEntrePartes, LocalDate dataOcorrencia) {

        this.nomeVitima = nomeVitima;
        this.idadeVitima = idadeVitima;
        this.escolaridadeVitima = escolaridadeVitima;
        this.nacionalidadeVitima = nacionalidadeVitima;
        this.nomeAgressor = nomeAgressor;
        this.idadeAgressor = idadeAgressor;
        this.escolaridadeAgressor = escolaridadeAgressor;
        this.nacionalidadeAgressor = nacionalidadeAgressor;
        this.vinculoEntrePartes = vinculoEntrePartes;
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getNomeVitima() {
        return nomeVitima;
    }

    public void setNomeVitima(String nomeVitima) {
        this.nomeVitima = nomeVitima;
    }

    public int getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(int idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public Escolaridade getEscolaridadeVitima() {
        return escolaridadeVitima;
    }

    public void setEscolaridadeVitima(Escolaridade escolaridadeVitima) {
        this.escolaridadeVitima = escolaridadeVitima;
    }

    public Nacionalidade getNacionalidadeVitima() {
        return nacionalidadeVitima;
    }

    public void setNacionalidadeVitima(Nacionalidade nacionalidadeVitima) {
        this.nacionalidadeVitima = nacionalidadeVitima;
    }

    public String getNomeAgressor() {
        return nomeAgressor;
    }

    public void setNomeAgressor(String nomeAgressor) {
        this.nomeAgressor = nomeAgressor;
    }

    public int getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(int idadeAgressor) {
        this.idadeAgressor = idadeAgressor;
    }

    public Escolaridade getEscolaridadeAgressor() {
        return escolaridadeAgressor;
    }

    public void setEscolaridadeAgressor(Escolaridade escolaridadeAgressor) {
        this.escolaridadeAgressor = escolaridadeAgressor;
    }

    public Vinculo getVinculoEntrePartes() {
        return vinculoEntrePartes;
    }

    public void setVinculoEntrePartes(Vinculo vinculoEntrePartes) {
        this.vinculoEntrePartes = vinculoEntrePartes;
    }

    public Nacionalidade getNacionalidadeAgressor() {
        return nacionalidadeAgressor;
    }

    public void setNacionalidadeAgressor(Nacionalidade nacionalidadeAgressor) {
        this.nacionalidadeAgressor = nacionalidadeAgressor;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    @Override
    public String toString() {
        return "Identificaão das Partes:" +
                "Vítim:'" + nomeVitima + '\'' +
                ", idade da vítima: " + idadeVitima +
                ", escolaridade da vítima:" + escolaridadeVitima +
                ", nacionalidade da vítima:" + nacionalidadeVitima +
                ", agressor:'" + nomeAgressor + '\'' +
                ", idade do agressor:" + idadeAgressor +
                ", escolaridade do agressor:" + escolaridadeAgressor +
                ", nacionalidade do agressor:" + nacionalidadeAgressor +
                ", vínculo entre as partes:" + vinculoEntrePartes +
                ", data da ocorrência:" + dataOcorrencia +
                '}';
    }
}
