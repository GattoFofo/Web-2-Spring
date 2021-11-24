package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Diretor;
import server.locadora.repository.DiretorRepository;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DiretorController {
    //private DiretorService diretorService = new DiretorService();
    @Autowired
    private DiretorRepository diretorRepository;

    @GetMapping(value = "/diretores")
    public List<Diretor> getDiretores() {
        //return diretorService.getDiretores();
        return diretorRepository.findAll();
    }

    @PostMapping("/diretor/{aux_nome}")
    public ResponseEntity addDiretor(
            @PathVariable(value = "aux_nome") String name
    ) {
        //Create save Object
        Diretor diretor = new Diretor();
        diretor.setNome(name);

        //Treat error to Save
        try {
            this.diretorRepository.save(diretor);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/diretor/{aux_id}/{aux_nome}")
    public ResponseEntity attDiretor(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_nome") String name
    ) {
        //Treat error to Save
        try {
            Diretor diretor = this.diretorRepository.findById(id).orElse(null);

            diretor.setNome(name);

            this.diretorRepository.save(diretor);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/diretor/{aux_id}")
    public ResponseEntity delDiretor(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            this.diretorRepository.deleteById(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
