package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOFonarOCRMetadados;
import br.com.devance.fonar.servicos.ServicoFonarOCR;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/fonars")
@RequiredArgsConstructor
public class ControladorFonarOCR {

    private final ServicoFonarOCR servicoFonarOCR;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/ocr-upload", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadFonarOCR(
            @RequestParam("metadados") String metadadosJson,
            @RequestPart("arquivo") MultipartFile arquivo
    ) {
        try {
            DTOFonarOCRMetadados metadados = objectMapper.readValue(metadadosJson, DTOFonarOCRMetadados.class);
            servicoFonarOCR.processarUpload(metadados, arquivo);
            return ResponseEntity.ok("Upload realizado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + e.getMessage());
        }
    }
}
