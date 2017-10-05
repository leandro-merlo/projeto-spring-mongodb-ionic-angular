package br.com.leandro.config;

import br.com.leandro.entities.Perfil;
import br.com.leandro.entities.Usuario;
import br.com.leandro.repositories.PerfilRepository;
import br.com.leandro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Perfil> perfis = perfilRepository.findAll();
        if (perfis.isEmpty()) {
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            perfilRepository.save(new Perfil("ROLE_OREIA"));
        }

        Perfil p = perfilRepository.findByNome("ROLE_ADMIN");

        List<Perfil> novos = new ArrayList<>();
        novos.add(p);
        usuarioRepository.save(new Usuario("ADMIN", "admin@teste.com", "123", novos));
    }
}
