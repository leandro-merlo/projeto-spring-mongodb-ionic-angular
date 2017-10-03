package br.com.leandro.controllers;

import br.com.leandro.entities.Usuario;
import br.com.leandro.repositories.UsuarioRepository;
import br.com.leandro.services.UsuarioService;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackageClasses = {UsuarioService.class, UsuarioRepository.class})
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping("/usuarios")
    public List<Usuario> listUsuarios(){
        return service.listaUsuarios();
    }
    
    @PostMapping("/usuarios")
    public List<Usuario> listUsuarios(@RequestBody Usuario usuario){
        return service.listaUsuarios(usuario);
    }
}
