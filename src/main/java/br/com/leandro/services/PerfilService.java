/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.leandro.services;

import br.com.leandro.entities.Perfil;
import br.com.leandro.entities.Perfil;
import br.com.leandro.repositories.PerfilRepository;
import br.com.leandro.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    
    @Autowired
    PerfilRepository repository;
    
    public List<Perfil> listaPerfis(){
        return repository.findAll();
    }

    public Page<Perfil> listaPerfisPaginada(int pagina, int tamanho) {
        Pageable page = new PageRequest(pagina, tamanho);
        return repository.findAll(page);
    }

    public List<Perfil> procurarPorNome(String nome){
        return repository.findByNomeLikeIgnoreCase(nome);
    }

    public Perfil salvarPerfil(Perfil usuarioAdd) {
        return repository.save(usuarioAdd);
    }

    public void deletarPerfil(String id){
        repository.delete(id);
    }

    public Perfil procurarPorId(String id){
        return repository.findOne(id);
    }
}
