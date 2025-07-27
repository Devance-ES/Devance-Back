package br.com.devance.fonar.servicos;

import br.com.devance.fonar.dto.DTOCadastroUsuario;
import br.com.devance.fonar.enums.PerfilUsuario;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.models.Delegado;
import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.SuperAdministrador;
import br.com.devance.fonar.models.Vitima;

import br.com.devance.fonar.repositorios.RepositorioUsuario;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ServicoAutenticacao implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // O metodo findByCpf ou findByEmail deve retornar um Optional<Usuario>.
        // Como Usuario implementa UserDetails, você pode retornar a própria instância de Usuario.
        return repositorioUsuario.findByCpf(login)
                .orElseGet(() -> repositorioUsuario.findByEmail(login)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login)));
    }

    // Metodo para registrar um novo usuário
    @Transactional
    public Usuario registrarUsuario(DTOCadastroUsuario dtoCadastro) {
        if (repositorioUsuario.existsByCpf(dtoCadastro.getCpf())) {
            throw new IllegalArgumentException("Já existe um usuário com este CPF.");
        }
        if (repositorioUsuario.existsByEmail(dtoCadastro.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este e-mail.");
        }

        // Determinar qual subclasse de Usuario criar com base no perfil
        Usuario novoUsuario;
        switch (dtoCadastro.getPerfil()) {
            case DELEGADO:
                novoUsuario = new Delegado(); // Construtor sem argumentos
                break;
            case FUNCIONARIO_SECUNDARIO:
                novoUsuario = new FuncionarioSecundario(); // Construtor sem argumentos
                break;
            default:
                throw new IllegalArgumentException("Perfil de usuário inválido.");
        }

        // Copiar propriedades comuns (nome, cpf, email, dataNascimento)
        BeanUtils.copyProperties(dtoCadastro, novoUsuario, "senha"); // Copia tudo menos a senha (que será hasheada)

        novoUsuario.setSenha(passwordEncoder.encode(dtoCadastro.getSenha()));

        // Definir o perfil diretamente (já que o atributo está na classe Usuario)
        novoUsuario.setPerfil(dtoCadastro.getPerfil());

        // Outros atributos padrão da classe Usuario (dataCadastro, ativo, tentativasFalhas)
        novoUsuario.setDataCadastro(LocalDateTime.now());
        novoUsuario.setAtivo(true);
        novoUsuario.setTentativasFalhas(0);

        // Salvar o novo usuário (que será persistido na tabela usuarios_base)
        Usuario usuarioSalvo = repositorioUsuario.save(novoUsuario);

        // Retornar o objeto completo salvo
        return usuarioSalvo;
    }
}