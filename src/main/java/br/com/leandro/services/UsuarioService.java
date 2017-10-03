/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.leandro.services;

import br.com.leandro.entities.Usuario;
import br.com.leandro.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;
    
    public List<Usuario> listaUsuarios(){
        return repository.findAll();
    }
    
    public List<Usuario> listaUsuarios(Usuario usuarioAdd) {
        repository.save(usuarioAdd);
        return listaUsuarios();
    }
    
    
}
