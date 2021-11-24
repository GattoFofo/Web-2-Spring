package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Ator;
import server.locadora.repository.AtorRepository;
import server.locadora.service.AtorService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AtorController {
    //private AtorService atorService = new AtorService();
    @Autowired
    private AtorRepository atorRepository;

    @GetMapping(value = "/atores")
    public List<Ator> getAtores() {
        //return atorService.getAtores();
        return atorRepository.findAll();
    }

    @PostMapping("/ator/{aux_nome}")
    public ResponseEntity addAtor(
            @PathVariable(value = "aux_nome") String name
    ) {
        //Create save Object
        Ator ator = new Ator();
        ator.setNome(name);

        //Treat error to Save
        try {
            this.atorRepository.save(ator);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/ator/{aux_id}/{aux_nome}")
    public ResponseEntity attAtor(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_nome") String name
    ) {
        //Treat error to Save
        try {
            Ator ator = this.atorRepository.findById(id).orElse(null);

            ator.setNome(name);

            this.atorRepository.save(ator);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/ator/{aux_id}")
    public ResponseEntity delAtor(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            this.atorRepository.deleteById(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
