package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.Classe;
import server.locadora.repository.ClasseRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> getClasses() {
        return classeRepository.findAll();
    }

    public void save(String name, double valor, String prazoDevolucao) throws IllegalArgumentException, ParseException {
        //Create save Object
        Classe classe = new Classe();
        classe.setNome(name);
        classe.setValor(valor);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        classe.setPrazoDevolucao(dateFormat.parse(prazoDevolucao));

        this.classeRepository.save(classe);
    }

    public void update(Long id, String name, double valor, String prazoDevolucao) throws IllegalArgumentException, ParseException {
        Classe classe = this.classeRepository.findById(id).orElse(null);

        classe.setNome(name);
        classe.setValor(valor);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        classe.setPrazoDevolucao(dateFormat.parse(prazoDevolucao));

        this.classeRepository.save(classe);
    }

    public void delete(Long id) throws IllegalArgumentException {
        this.classeRepository.deleteById(id);
    }
}
