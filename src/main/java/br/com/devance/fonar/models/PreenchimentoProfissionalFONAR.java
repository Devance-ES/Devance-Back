package br.com.devance.fonar.models;

import br.com.devance.fonar.enums.TipoPreenchimentoProfissional;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PreenchimentoProfissionalFONAR {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_preenchimento_profissional")
    private TipoPreenchimentoProfissional tipoPreenchimentoProfissional;
}

