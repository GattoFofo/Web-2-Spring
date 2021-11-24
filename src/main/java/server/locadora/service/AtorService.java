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
}
