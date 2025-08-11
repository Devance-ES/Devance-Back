package br.com.devance.fonar.servicos;

import br.com.devance.fonar.dto.DTOFonarOCRMetadados;
import br.com.devance.fonar.models.FonarOCR;
import br.com.devance.fonar.repositorios.RepositorioFonarOCR;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicoFonarOCR {

    private final RepositorioFonarOCR repositorioFonarOCR;

    @Value("${app.upload.dir}")
    private String caminhoBase;

    public void processarUpload(DTOFonarOCRMetadados metadados, MultipartFile arquivo) throws IOException {
        validarArquivo(arquivo);
        validarCpf(metadados);

        // Criar pasta se não existir
        File pasta = new File(caminhoBase);
        if (!pasta.exists()) {
            boolean criado = pasta.mkdirs();
            if (!criado) {
                throw new IOException("Não foi possível criar o diretório de upload: " + caminhoBase);
            }
        }

        String nomeArquivo = UUID.randomUUID() + "_" + StringUtils.cleanPath(Objects.requireNonNull(arquivo.getOriginalFilename()));
        File destino = new File(pasta, nomeArquivo);

        // Salva o arquivo no disco
        arquivo.transferTo(destino);

        // Cria a entidade e salva no banco
        FonarOCR fonarOCR = new FonarOCR();
        fonarOCR.setCpf(metadados.isCpfNaoFornecido() ? null : metadados.getCpf());
        fonarOCR.setCaminhoArquivo(destino.getPath());
        fonarOCR.setDataEnvio(LocalDateTime.now());
        fonarOCR.setStatus("PENDENTE");

        repositorioFonarOCR.save(fonarOCR);
    }

    private void validarArquivo(MultipartFile arquivo) {
        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException("Arquivo não fornecido.");
        }
        String nomeArquivo = arquivo.getOriginalFilename();
        if (nomeArquivo == null || !nomeArquivo.toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("Formato de arquivo inválido. Apenas PDF é permitido.");
        }
    }

    private void validarCpf(DTOFonarOCRMetadados metadados) {
        if (!metadados.isCpfNaoFornecido()) {
            String cpf = metadados.getCpf();
            if (cpf == null || !cpf.matches("\\d{11}")) {
                throw new IllegalArgumentException("CPF inválido.");
            }
        }
    }
}