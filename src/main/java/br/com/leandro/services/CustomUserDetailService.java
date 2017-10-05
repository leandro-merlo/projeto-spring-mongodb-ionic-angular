package br.com.leandro.services;

import br.com.leandro.entities.Usuario;
import br.com.leandro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Autowired
    public CustomUserDetailService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = this.repository.findByEmail(username);
        if (u == null) {
            throw new UsernameNotFoundException(String.format("Usuário não existe", username));
        }
        return new UserRepositoryUserDetail(u);
    }

    private final static class UserRepositoryUserDetail extends Usuario implements UserDetails{



        public UserRepositoryUserDetail(Usuario user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getPerfis();
        }

        @Override
        public String getPassword() {
            return getSenha();
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
