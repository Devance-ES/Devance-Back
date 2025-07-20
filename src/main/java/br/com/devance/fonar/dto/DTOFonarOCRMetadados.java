package br.com.devance.fonar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DTOFonarOCRMetadados {

    private String cpf;
    private boolean cpfNaoFornecido;
}
