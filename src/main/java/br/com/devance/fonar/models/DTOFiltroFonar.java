package br.com.devance.fonar.models;

// DTO para filtros e ordenação na consulta de histórico
public class DTOFiltroFonar {
    private String textoBusca; // Para busca de texto completo
    private String ordenarPor;    // Campo para ordenar (ex: "dataRegistro", "grauDeRiscoCalculado")
    private String direcao;  // Direção da ordenação (ex: "ASC", "DESC")

    // Construtor padrão
    public DTOFiltroFonar() {}

    // Construtor com campos
    public DTOFiltroFonar(String textoBusca, String ordenarPor, String direcao) {
        this.textoBusca = textoBusca;
        this.ordenarPor = ordenarPor;
        this.direcao = direcao;
    }

    // Getters e Setters
    public String getTextoBusca() { return textoBusca; }
    public void setTextoBusca(String textoBusca) { this.textoBusca = textoBusca; }

    public String getOrdenarPor() { return ordenarPor; }
    public void setOrdenarPor(String ordenarPor) { this.ordenarPor = ordenarPor; }

    public String getDirecao() { return direcao; }
    public void setDirecao(String direcao) { this.direcao = direcao; }
}