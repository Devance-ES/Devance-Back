package br.com.devance.fonar.servicos;

import br.com.devance.fonar.enums.PerfilUsuario;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado; // Reutiliza exceção de recurso não encontrado para usuário
import br.com.devance.fonar.models.Usuario; // Classe base de usuário
import br.com.devance.fonar.models.Delegado; // Subclasses para inferir perfil
import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.SuperAdministrador;

import br.com.devance.fonar.repositorios.RepositorioUsuario; // Repositório genérico de usuário

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User; // Objeto User do Spring Security
import org.springframework.security.core.userdetails.UserDetails; // Interface UserDetails
import org.springframework.security.core.userdetails.UserDetailsService; // Interface UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Exceção para usuário não encontrado
import org.springframework.stereotype.Service;

@Service
public class ServicoAutenticacao implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // O 'username' pode ser o CPF ou o email
        Usuario usuario = repositorioUsuario.findByCpf(username)
                .orElseGet(() -> repositorioUsuario.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username)));

        // --- Lógica para identificar o perfil a partir da classe concreta ---
        // Esta lógica é necessária porque a classe Usuario (base) não tem um campo 'perfil'
        String role = "";
        if (usuario instanceof Delegado) {
            role = PerfilUsuario.DELEGADO.name();
        } else if (usuario instanceof FuncionarioSecundario) {
            role = PerfilUsuario.FUNCIONARIO_SECUNDARIO.name();
        } else if (usuario instanceof SuperAdministrador) {
            role = PerfilUsuario.SUPER_ADMIN.name();
        } else {
            throw new UsernameNotFoundException("Perfil de usuário não reconhecido para: " + username);
        }
        // --- Fim da lógica de perfil ---
        repositorioUsuario.save(usuario); // Salva a atualização

        // Retorna um objeto UserDetails que o Spring Security usará para comparação de senha e autorização
        return User.withUsername(usuario.getCpf()) // Ou usuario.getEmail() se esse for o username principal
                .password(usuario.getSenha()) // >>>>> ESTE É A SENHA QUE SERÁ COMPARADA <<<<< (hash ou texto plano)
                .roles(role) // As roles são o nome do PerfilUsuario
                .build();
    }
}