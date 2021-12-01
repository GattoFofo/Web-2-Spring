package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.Dependente;
import server.locadora.domain.Socio;
import server.locadora.repository.DependenteRepository;
import server.locadora.repository.SocioRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class DependenteService {
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private DependenteRepository dependenteRepository;

    public List<Dependente> getDependentes() {
        return dependenteRepository.findAll();
    }

    public void save(Long socioId, String name, String endereco, String tel, String sexo, String cpf, String nascimento, Boolean ativo) throws IllegalArgumentException, ParseException {
        //Create save Object
        Socio socio = this.socioRepository.findById(socioId).orElse(null);

        Dependente dependente = new Dependente();
        dependente.setNome(name);
        dependente.setEndereco(endereco);
        dependente.setTelefone(tel);
        dependente.setSexo(sexo);
        dependente.setCpf(cpf);
        dependente.setEstahAtivo(ativo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dependente.setDtNascimento(dateFormat.parse(nascimento));

        this.dependenteRepository.save(dependente);
    }

    public void update(Long id, String name, String endereco, String tel, String sexo, String cpf, String nascimento, Boolean ativo) throws IllegalArgumentException, ParseException {
        Dependente dependente = this.dependenteRepository.findById(id).orElse(null);

        dependente.setNome(name);
        dependente.setEndereco(endereco);
        dependente.setTelefone(tel);
        dependente.setSexo(sexo);
        dependente.setCpf(cpf);
        dependente.setEstahAtivo(ativo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dependente.setDtNascimento(dateFormat.parse(nascimento));

        this.dependenteRepository.save(dependente);
    }

    public void delete(Long socioId, Long id) throws IllegalArgumentException {
        this.dependenteRepository.deleteById(id);
    }
}
