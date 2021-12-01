package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.Diretor;
import server.locadora.repository.DiretorRepository;

import java.util.List;

@Component
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;

    public List<Diretor> getDiretores() {
        return diretorRepository.findAll();
    }

    public void save(String name) throws IllegalArgumentException{
        //Create save Object
        Diretor diretor = new Diretor();
        diretor.setNome(name);

        this.diretorRepository.save(diretor);
    }

    public void update(Long id, String name) throws IllegalArgumentException{
        Diretor diretor = this.diretorRepository.findById(id).orElse(null);

        diretor.setNome(name);

        this.diretorRepository.save(diretor);
    }

    public void delete(Long id) throws IllegalArgumentException {
        this.diretorRepository.deleteById(id);
    }
}
