package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import server.locadora.domain.Ator;
import server.locadora.repository.AtorRepository;

import java.util.List;

@RestController
public class AtorService {
    @Autowired
    private AtorRepository atorRepository;

    public List<Ator> getAtores() {
        return atorRepository.findAll();
    }

    public void save(String name) throws IllegalArgumentException {
        //Create save Object
        Ator ator = new Ator();
        ator.setNome(name);

        this.atorRepository.save(ator);
    }

    public void update(Long id, String name) throws IllegalArgumentException {
        Ator ator = this.atorRepository.findById(id).orElse(null);

        ator.setNome(name);

        this.atorRepository.save(ator);
    }

    public void delete(Long id) throws IllegalArgumentException{
        this.atorRepository.deleteById(id);
    }
}
