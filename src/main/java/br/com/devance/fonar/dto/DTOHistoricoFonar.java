package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.Status; // Assumindo que Status é um enum
import br.com.devance.fonar.models.Fonar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data // Gera getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera construtor sem argumentos, necessário para frameworks como Spring/Jackson
@AllArgsConstructor // Gera construtor com todos os argumentos, útil para testes e Builder
@Builder // Gera o padrão Builder para construção de objetos de forma fluente
public class DTOHistoricoFonar {
    private UUID idFonar;
    private LocalDate dataRegistro;
    private String localRegistro; // Pode ser o nome da delegacia ou o local de registro literal
    private String grauDeRisco;
    private Status statusTriagem; // Use o enum Status diretamente aqui
    private String encaminhamentos;
    private boolean aptoParaEdicao;

    // Construtor específico para mapear a partir da entidade Fonar
    // (Este construtor não é gerado pelo @AllArgsConstructor sozinho, é customizado)
    public DTOHistoricoFonar(Fonar fonar) {
        this.idFonar = fonar.getIdFonar();
        this.dataRegistro = fonar.getDataRegistro();
        // Assume que localRegistro pode vir do nome da delegacia ou do campo localRegistro do Fonar
        this.localRegistro = fonar.getDelegacia() != null ? fonar.getDelegacia().getNome() : null; // Exemplo: pegar nome da delegacia
        // Ou, se localRegistro é um campo direto no Fonar:
        // this.localRegistro = fonar.getLocalRegistro();
        this.grauDeRisco = fonar.getGrauDeRiscoCalculado();
        this.statusTriagem = (Status) fonar.getStatusTriagem();
        // Lógica para determinar se é apto para edição (Baseado no status da triagem)
        this.aptoParaEdicao = Status.EM_ATENDIMENTO.equals(fonar.getStatusTriagem());
    }
}