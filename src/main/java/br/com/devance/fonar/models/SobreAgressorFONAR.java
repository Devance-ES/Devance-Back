package br.com.devance.fonar.models;


public class SobreAgressorFONAR
{
    private boolean usoAbusivoAlcool;

    private boolean usoAbusivoDrogas;

    private boolean nenhumUsoAbusivo;

    private boolean desconheceUsoAbusivo;

    // 2. Saúde Mental/Condição Médica (psicológico do agressor)
    private boolean doenteMedicado;

    private boolean doenteNaoMedicado;

    private boolean naoEDoente;

    private boolean desconheceDoenca;

    // 3. Histórico de Medida Protetiva
    private boolean descumpriuMedidaProt;

    // 4. Tentativa de Suicídio (do agressor, implica em risco)
    private boolean tentouSuicidio;

    // 5. Situação Financeira (dependência econômica)
    private boolean desempregadoDifiFin; // Desempregado e/ou com dificuldade financeira

    private boolean desconheceSituFin;

    // 6. Posse de Armas (red flag)
    private boolean temArmaDeFogo;

    private boolean desconheceArma;

    // 7. Violência contra Outros/Terceiros
    private boolean violenciaFilhos;

    private boolean violenciaFamiliares;

    private boolean violenciaOutrasPessoas;

    private boolean violenciaAnimais;

    private boolean naoViolenciaOutros; //

    private boolean desconheceViolenciaOutros; //

    public SobreAgressorFONAR(boolean usoAbusivoAlcool, boolean usoAbusivoDrogas, boolean nenhumUsoAbusivo,
                              boolean desconheceUsoAbusivo, boolean doenteMedicado, boolean doenteNaoMedicado,
                              boolean naoEDoente, boolean desconheceDoenca, boolean descumpriuMedidaProt,
                              boolean tentouSuicidio, boolean desempregadoDifiFin, boolean desconheceSituFin,
                              boolean temArmaDeFogo, boolean desconheceArma, boolean violenciaFilhos,
                              boolean violenciaFamiliares, boolean violenciaOutrasPessoas, boolean violenciaAnimais,
                              boolean naoViolenciaOutros, boolean desconheceViolenciaOutros)
    {
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
