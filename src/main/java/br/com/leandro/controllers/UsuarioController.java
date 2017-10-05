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
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping("/usuarios")
    public List<Usuario> listUsuarios(){
        return service.listaUsuarios();
    }

    @GetMapping("/usuarios/{page}/{size}")
    public Page<Usuario> listUsuarios(@PathVariable int page, @PathVariable int size){
        return service.listaUsuariosPaginada(page, size);
    }

    @PostMapping("/usuarios")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return service.salvarUsuario(usuario);
    }

    @PutMapping("/usuarios")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        return service.salvarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuario(@PathVariable String id){
        service.deletarUsuario(id);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario usuarioPorId(@PathVariable String id){
        return service.procurarPorId(id);
    }

    @GetMapping("/usuarios/procurar/{nome}")
    public List<Usuario> usuarioPorNome(@PathVariable String nome){
        return service.procurarPorNome(nome);
    }

}
