package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.Ator;
import server.locadora.domain.Classe;
import server.locadora.domain.Diretor;
import server.locadora.domain.Titulo;
import server.locadora.repository.TituloRepository;

import java.util.List;

@Component
public class TituloService {
    @Autowired
    private TituloRepository tituloRepository;

    public List<Titulo> getTitulos() {
        return tituloRepository.findAll();
    }

    public void save(
            String name,
            Long ano,
            String sinopse,
            String categoria,
            List<Ator> atores,
            Diretor diretor,
            Classe classe
    )
            throws IllegalArgumentException {
        //Create save Object
        Titulo titulo = new Titulo();
        titulo.setNome(name);
        titulo.setAno(ano);
        titulo.setSinopse(sinopse);
        titulo.setCategoria(categoria);
        titulo.setAtores(atores);
        titulo.setDiretor(diretor);
        titulo.setClasse(classe);

        this.tituloRepository.save(titulo);
    }

    public void update(
            Long id,
            String name,
            Long ano,
            String sinopse,
            String categoria,
            List<Ator> atores,
            Diretor diretor,
            Classe classe
    )
            throws IllegalArgumentException {
        Titulo titulo = this.tituloRepository.findById(id).orElse(null);

        titulo.setNome(name);
        titulo.setAno(ano);
        titulo.setSinopse(sinopse);
        titulo.setCategoria(categoria);
        titulo.setAtores(atores);
        titulo.setDiretor(diretor);
        titulo.setClasse(classe);

        this.tituloRepository.save(titulo);
    }

    public void delete(Long id) throws IllegalArgumentException {
        this.tituloRepository.deleteById(id);
    }
}
