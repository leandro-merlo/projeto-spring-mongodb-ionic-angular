package br.com.leandro.controllers;

import br.com.leandro.entities.Perfil;
import br.com.leandro.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilController {
    
    @Autowired
    PerfilService service;
    
    @GetMapping("/perfis")
    public List<Perfil> listPerfis(){
        return service.listaPerfis();
    }

    @GetMapping("/perfis/{page}/{size}")
    public Page<Perfil> listPerfis(@PathVariable int page, @PathVariable int size){
        return service.listaPerfisPaginada(page, size);
    }

    @PostMapping("/perfis")
    public Perfil salvarPerfil(@RequestBody Perfil perfil){
        return service.salvarPerfil(perfil);
    }

    @PutMapping("/perfis")
    public Perfil editarPerfil(@RequestBody Perfil perfil){
        return service.salvarPerfil(perfil);
    }

    @DeleteMapping("/perfis/{id}")
    public void deletarPerfil(@PathVariable String id){
        service.deletarPerfil(id);
    }

    @GetMapping("/perfis/{id}")
    public Perfil perfilPorId(@PathVariable String id){
        return service.procurarPorId(id);
    }

    @GetMapping("/perfis/procurar/{nome}")
    public List<Perfil> perfilPorNome(@PathVariable String nome){
        return service.procurarPorNome(nome);
    }

}
