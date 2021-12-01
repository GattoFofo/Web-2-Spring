package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Ator;
import server.locadora.service.AtorService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AtorController {
    @Autowired
    private AtorService atorService;

    @GetMapping(value = "/atores")
    public List<Ator> getAtores() {
        return atorService.getAtores();
    }

    @PostMapping("/ator/{aux_nome}")
    public ResponseEntity addAtor(
            @PathVariable(value = "aux_nome") String name
    ) {
        //Treat error to Save
        try {
            atorService.save(name);

            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
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
            atorService.update(id, name);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
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
            atorService.delete(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
