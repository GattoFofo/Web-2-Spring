package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Ator;
import server.locadora.domain.Classe;
import server.locadora.domain.Diretor;
import server.locadora.domain.Titulo;
import server.locadora.repository.TituloRepository;
import server.locadora.service.TituloService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TituloController {
    @Autowired
    private TituloService tituloService;

    @GetMapping(value = "/titulos")
    public List<Titulo> getTitulos() {
        return tituloService.getTitulos();
    }

    @PostMapping("/titulo/{aux_nome}/{aux_ano}/{aux_sinopse}/{aux_categoria}/{aux_atores}/{aux_diretor}/{aux_classe}")
    public ResponseEntity addTitulo(
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_ano") Long ano,
            @PathVariable(value = "aux_sinopse") String sinopse,
            @PathVariable(value = "aux_categoria") String categoria,
            @PathVariable(value = "aux_atores") List<Ator> atores,
            @PathVariable(value = "aux_diretor") Diretor diretor,
            @PathVariable(value = "aux_classe") Classe classe
    ) {
        //Treat error to Save
        try {
            tituloService.save(name, ano, sinopse, categoria, atores, diretor, classe);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/titulo/{aux_id}/{aux_nome}/{aux_ano}/{aux_sinopse}/{aux_categoria}/{aux_atores}/{aux_diretor}/{aux_classe}")
    public ResponseEntity attTitulo(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_ano") Long ano,
            @PathVariable(value = "aux_sinopse") String sinopse,
            @PathVariable(value = "aux_categoria") String categoria,
            @PathVariable(value = "aux_atores") List<Ator> atores,
            @PathVariable(value = "aux_diretor") Diretor diretor,
            @PathVariable(value = "aux_classe") Classe classe
    ) {
        //Treat error to Save
        try {
            tituloService.update(id, name, ano, sinopse, categoria, atores, diretor, classe);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/titulo/{aux_id}")
    public ResponseEntity delTitulo(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            tituloService.delete(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
