package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.Status;

import java.time.LocalDate;
import java.util.UUID;

// DTO para representar um item na lista de histórico de FONARs
public class DTOHistoricoFonar {
    private UUID idFonar;
    private LocalDate dataRegistro;
    private String localRegistro; // Ou nome da delegacia
    private String grauDeRisco;
    private Enum<Status> statusTriagem;
    private String encaminhamentos;
    private boolean aptoParaEdicao; // Baseado no status do FONAR

    // Construtor a partir da entidade Fonar
    public DTOHistoricoFonar(Fonar fonar) {
        this.idFonar = fonar.getIdFonar();
        this.dataRegistro = fonar.getDataRegistro();
        this.localRegistro = fonar.getDelegacia() != null ? fonar.getDelegacia().getNome() : null; // Pega o nome da delegacia
        this.grauDeRisco = fonar.getGrauDeRiscoCalculado();
        this.statusTriagem = fonar.getStatusTriagem();

        // Pode editar se for rascunho ou em aberto
        this.aptoParaEdicao = "RASCUNHO".equalsIgnoreCase(fonar.getStatusTriagem().toString()) ||
                "EM_ABERTO".equalsIgnoreCase(fonar.getStatusTriagem().toString());
    }

    // Getters
    public UUID getIdFonar() { return idFonar; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public String getLocalRegistro() { return localRegistro; }
    public String getGrauDeRisco() { return grauDeRisco; }
    public Enum<Status> getStatusTriagem() { return statusTriagem; }
    public String getEncaminhamentos() { return encaminhamentos; }
    public boolean isAptoParaEdicao() { return aptoParaEdicao; }

    // Setters (opcional, se necessário para mapeamento)
    public void setIdFonar(UUID idFonar) { this.idFonar = idFonar; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
    public void setLocalRegistro(String localRegistro) { this.localRegistro = localRegistro; }
    public void setGrauDeRisco(String grauDeRisco) { this.grauDeRisco = grauDeRisco; }
    public void setStatusTriagem(Enum<Status> statusTriagem) { this.statusTriagem = statusTriagem; }
    public void setAptoParaEdicao(boolean aptoParaEdicao) { this.aptoParaEdicao = aptoParaEdicao; }
    public void setEncaminhamentos(String encaminhamentos) { this.encaminhamentos = encaminhamentos; }
}