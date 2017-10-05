package br.com.leandro.repositories;

import br.com.leandro.entities.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {
    public List<Perfil> findByNomeLikeIgnoreCase(String nome);
    public Perfil findByNome(String nome);
}
