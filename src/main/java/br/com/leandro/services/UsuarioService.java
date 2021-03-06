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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;
    
    public List<Usuario> listaUsuarios(){
        return repository.findAll();
    }

    public Page<Usuario> listaUsuariosPaginada(int pagina, int tamanho) {
        Pageable page = new PageRequest(pagina, tamanho);
        return repository.findAll(page);
    }

    public List<Usuario> procurarPorNome(String nome){
        return repository.findByNomeLikeIgnoreCase(nome);
    }

    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return repository.save(usuarioAdd);
    }

    public void deletarUsuario(String id){
        repository.delete(id);
    }

    public Usuario procurarPorId(String id){
        return repository.findOne(id);
    }
}
