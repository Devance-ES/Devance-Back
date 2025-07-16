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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ServicoAutenticacao implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário pelo CPF ou email
        Usuario usuario = repositorioUsuario.findByCpf(username)
                .orElseGet(() -> repositorioUsuario.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username)));

        if (!usuario.isAtivo()) {
            throw new UsernameNotFoundException("Usuário inativo ou bloqueado: " + username);
        }

        // Atualiza o último login
        usuario.setUltimoLogin(LocalDateTime.now());
        repositorioUsuario.save(usuario);

        // Retorna um objeto UserDetails que o Spring Security usará
        // A senha retornada aqui (usuario.getSenha()) será comparada pelo PasswordEncoder
        // O perfil (role) é obtido diretamente do atributo 'perfil' da entidade Usuario
        return User.withUsername(usuario.getCpf())
                .password(usuario.getSenha())
                .roles(usuario.getPerfil().name())
                .build();
    }

    // Metodo para registrar um novo usuário (Delegado, Funcionário, Vítima)
    @Transactional
    public Usuario registrarUsuario(DTOCadastroUsuario dtoCadastro) {
        // Validação de unicidade de CPF e Email
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

        novoUsuario.setSenha(dtoCadastro.getSenha());

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