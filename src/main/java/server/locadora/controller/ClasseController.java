package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Classe;
import server.locadora.repository.ClasseRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClasseController {
    //private ClasseService classeService = new ClasseService();
    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping(value = "/classes")
    public List<Classe> getClasses() {
        //return classeService.getClassees();
        return classeRepository.findAll();
    }

    @PostMapping("/classe/{aux_nome}/{aux_valor}/{aux_prazoDevolucao}")
    public ResponseEntity addClasse(
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_valor") double valor,
            @PathVariable(value = "aux_prazoDevolucao") String prazoDevolucao
    ) {
        //Create save Object
        Classe classe = new Classe();
        classe.setNome(name);
        classe.setValor(valor);

        //Treat error to Save
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            classe.setPrazoDevolucao(dateFormat.parse(prazoDevolucao));

            this.classeRepository.save(classe);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/classe/{aux_id}/{aux_nome}/{aux_valor}/{aux_prazoDevolucao}")
    public ResponseEntity attClasse(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_valor") double valor,
            @PathVariable(value = "aux_prazoDevolucao") String prazoDevolucao
    ) {
        //Treat error to Save
        try {
            Classe classe = this.classeRepository.findById(id).orElse(null);

            classe.setNome(name);
            classe.setValor(valor);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            classe.setPrazoDevolucao(dateFormat.parse(prazoDevolucao));

            this.classeRepository.save(classe);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/classe/{aux_id}")
    public ResponseEntity delClasse(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            this.classeRepository.deleteById(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
