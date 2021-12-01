package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.Socio;
import server.locadora.repository.SocioRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getSocios() {
        return socioRepository.findAll();
    }

    public void save(String name, String endereco, String tel, String sexo, String cpf, String nascimento, Boolean ativo) throws IllegalArgumentException, ParseException {
        //Create save Object
        Socio socio = new Socio();
        socio.setNome(name);
        socio.setEndereco(endereco);
        socio.setTelefone(tel);
        socio.setSexo(sexo);
        socio.setCpf(cpf);
        socio.setEstahAtivo(ativo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        socio.setDtNascimento(dateFormat.parse(nascimento));

        this.socioRepository.save(socio);
    }

    public void update(Long id, String name, String endereco, String tel, String sexo, String cpf, String nascimento, Boolean ativo) throws IllegalArgumentException, ParseException {
        Socio socio = this.socioRepository.findById(id).orElse(null);

        socio.setNome(name);
        socio.setEndereco(endereco);
        socio.setTelefone(tel);
        socio.setSexo(sexo);
        socio.setCpf(cpf);
        socio.setEstahAtivo(ativo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        socio.setDtNascimento(dateFormat.parse(nascimento));

        this.socioRepository.save(socio);
    }

    public void delete(Long id) throws IllegalArgumentException {
        this.socioRepository.deleteById(id);
    }
}
