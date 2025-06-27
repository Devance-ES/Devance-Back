package br.com.devance.fonar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SobreAgressorFONAR {
    @Column(name = "agressor_uso_abusivo_alcool")
    private boolean usoAbusivoAlcool;

    @Column(name = "agressor_uso_abusivo_drogas")
    private boolean usoAbusivoDrogas;

    @Column(name = "agressor_nenhum_uso_abusivo")
    private boolean nenhumUsoAbusivo;

    @Column(name = "agressor_desconhece_uso_abusivo")
    private boolean desconheceUsoAbusivo;

    @Column(name = "agressor_doente_medicado")
    private boolean doenteMedicado;

    @Column(name = "agressor_doente_nao_medicado")
    private boolean doenteNaoMedicado;

    @Column(name = "agressor_nao_e_doente")
    private boolean naoEDoente;

    @Column(name = "agressor_desconhece_doenca")
    private boolean desconheceDoenca;

    @Column(name = "agressor_descumpriu_medida_prot")
    private boolean descumpriuMedidaProt;

    @Column(name = "agressor_tentou_suicidio")
    private boolean tentouSuicidio;

    @Column(name = "agressor_desempregado_difi_fin")
    private boolean desempregadoDifiFin;

    @Column(name = "agressor_desconhece_situ_fin")
    private boolean desconheceSituFin;

    @Column(name = "agressor_tem_arma_de_fogo")
    private boolean temArmaDeFogo;

    @Column(name = "agressor_desconhece_arma")
    private boolean desconheceArma;

    @Column(name = "agressor_violencia_filhos")
    private boolean violenciaFilhos;

    @Column(name = "agressor_violencia_familiares")
    private boolean violenciaFamiliares;

    @Column(name = "agressor_violencia_outras_pessoas")
    private boolean violenciaOutrasPessoas;

    @Column(name = "agressor_violencia_animais")
    private boolean violenciaAnimais;

    @Column(name = "agressor_nao_violencia_outros")
    private boolean naoViolenciaOutros;

    @Column(name = "agressor_desconhece_violencia_outros")
    private boolean desconheceViolenciaOutros;

    public SobreAgressorFONAR() {
    }

    public SobreAgressorFONAR(boolean usoAbusivoAlcool, boolean usoAbusivoDrogas, boolean nenhumUsoAbusivo,
                              boolean desconheceUsoAbusivo, boolean doenteMedicado, boolean doenteNaoMedicado,
                              boolean naoEDoente, boolean desconheceDoenca, boolean descumpriuMedidaProt,
                              boolean tentouSuicidio, boolean desempregadoDifiFin, boolean desconheceSituFin,
                              boolean temArmaDeFogo, boolean desconheceArma, boolean violenciaFilhos,
                              boolean violenciaFamiliares, boolean violenciaOutrasPessoas, boolean violenciaAnimais,
                              boolean naoViolenciaOutros, boolean desconheceViolenciaOutros) {
        this.usoAbusivoAlcool = usoAbusivoAlcool;
        this.usoAbusivoDrogas = usoAbusivoDrogas;
        this.nenhumUsoAbusivo = nenhumUsoAbusivo;
        this.desconheceUsoAbusivo = desconheceUsoAbusivo;
        this.doenteMedicado = doenteMedicado;
        this.doenteNaoMedicado = doenteNaoMedicado;
        this.naoEDoente = naoEDoente;
        this.desconheceDoenca = desconheceDoenca;
        this.descumpriuMedidaProt = descumpriuMedidaProt;
        this.tentouSuicidio = tentouSuicidio;
        this.desempregadoDifiFin = desempregadoDifiFin;
        this.desconheceSituFin = desconheceSituFin;
        this.temArmaDeFogo = temArmaDeFogo;
        this.desconheceArma = desconheceArma;
        this.violenciaFilhos = violenciaFilhos;
        this.violenciaFamiliares = violenciaFamiliares;
        this.violenciaOutrasPessoas = violenciaOutrasPessoas;
        this.violenciaAnimais = violenciaAnimais;
        this.naoViolenciaOutros = naoViolenciaOutros;
        this.desconheceViolenciaOutros = desconheceViolenciaOutros;
    }

    public boolean isUsoAbusivoAlcool() {
        return usoAbusivoAlcool;
    }

    public void setUsoAbusivoAlcool(boolean usoAbusivoAlcool) {
        this.usoAbusivoAlcool = usoAbusivoAlcool;
    }

    public boolean isUsoAbusivoDrogas() {
        return usoAbusivoDrogas;
    }

    public void setUsoAbusivoDrogas(boolean usoAbusivoDrogas) {
        this.usoAbusivoDrogas = usoAbusivoDrogas;
    }

    public boolean isNenhumUsoAbusivo() {
        return nenhumUsoAbusivo;
    }

    public void setNenhumUsoAbusivo(boolean nenhumUsoAbusivo) {
        this.nenhumUsoAbusivo = nenhumUsoAbusivo;
    }

    public boolean isDesconheceUsoAbusivo() {
        return desconheceUsoAbusivo;
    }

    public void setDesconheceUsoAbusivo(boolean desconheceUsoAbusivo) {
        this.desconheceUsoAbusivo = desconheceUsoAbusivo;
    }

    public boolean isDoenteMedicado() {
        return doenteMedicado;
    }

    public void setDoenteMedicado(boolean doenteMedicado) {
        this.doenteMedicado = doenteMedicado;
    }

    public boolean isDoenteNaoMedicado() {
        return doenteNaoMedicado;
    }

    public void setDoenteNaoMedicado(boolean doenteNaoMedicado) {
        this.doenteNaoMedicado = doenteNaoMedicado;
    }

    public boolean isNaoEDoente() {
        return naoEDoente;
    }

    public void setNaoEDoente(boolean naoEDoente) {
        this.naoEDoente = naoEDoente;
    }

    public boolean isDesconheceDoenca() {
        return desconheceDoenca;
    }

    public void setDesconheceDoenca(boolean desconheceDoenca) {
        this.desconheceDoenca = desconheceDoenca;
    }

    public boolean isDescumpriuMedidaProt() {
        return descumpriuMedidaProt;
    }

    public void setDescumpriuMedidaProt(boolean descumpriuMedidaProt) {
        this.descumpriuMedidaProt = descumpriuMedidaProt;
    }

    public boolean isTentouSuicidio() {
        return tentouSuicidio;
    }

    public void setTentouSuicidio(boolean tentouSuicidio) {
        this.tentouSuicidio = tentouSuicidio;
    }

    public boolean isDesempregadoDifiFin() {
        return desempregadoDifiFin;
    }

    public void setDesempregadoDifiFin(boolean desempregadoDifiFin) {
        this.desempregadoDifiFin = desempregadoDifiFin;
    }

    public boolean isDesconheceSituFin() {
        return desconheceSituFin;
    }

    public void setDesconheceSituFin(boolean desconheceSituFin) {
        this.desconheceSituFin = desconheceSituFin;
    }

    public boolean isTemArmaDeFogo() {
        return temArmaDeFogo;
    }

    public void setTemArmaDeFogo(boolean temArmaDeFogo) {
        this.temArmaDeFogo = temArmaDeFogo;
    }

    public boolean isDesconheceArma() {
        return desconheceArma;
    }

    public void setDesconheceArma(boolean desconheceArma) {
        this.desconheceArma = desconheceArma;
    }

    public boolean isViolenciaFilhos() {
        return violenciaFilhos;
    }

    public void setViolenciaFilhos(boolean violenciaFilhos) {
        this.violenciaFilhos = violenciaFilhos;
    }

    public boolean isViolenciaFamiliares() {
        return violenciaFamiliares;
    }

    public void setViolenciaFamiliares(boolean violenciaFamiliares) {
        this.violenciaFamiliares = violenciaFamiliares;
    }

    public boolean isViolenciaOutrasPessoas() {
        return violenciaOutrasPessoas;
    }

    public void setViolenciaOutrasPessoas(boolean violenciaOutrasPessoas) {
        this.violenciaOutrasPessoas = violenciaOutrasPessoas;
    }

    public boolean isViolenciaAnimais() {
        return violenciaAnimais;
    }

    public void setViolenciaAnimais(boolean violenciaAnimais) {
        this.violenciaAnimais = violenciaAnimais;
    }

    public boolean isNaoViolenciaOutros() {
        return naoViolenciaOutros;
    }

    public void setNaoViolenciaOutros(boolean naoViolenciaOutros) {
        this.naoViolenciaOutros = naoViolenciaOutros;
    }

    public boolean isDesconheceViolenciaOutros() {
        return desconheceViolenciaOutros;
    }

    public void setDesconheceViolenciaOutros(boolean desconheceViolenciaOutros) {
        this.desconheceViolenciaOutros = desconheceViolenciaOutros;
    }
}