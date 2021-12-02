package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Socio;
import server.locadora.service.SocioService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SocioController {
    @Autowired
    private SocioService socioService;

    @GetMapping(value = "/socios")
    public List<Socio> getSocios() {
        return socioService.getSocios();
    }

    @PostMapping("/socio/{aux_nome}/{aux_endereco}/{aux_telefone}/{aux_sexo}/{aux_cpf}/{aux_dtNascimento}/{aux_ativo}")
    public ResponseEntity addSocio(
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_endereco") String endereco,
            @PathVariable(value = "aux_telefone") String telefone,
            @PathVariable(value = "aux_sexo") String sexo,
            @PathVariable(value = "aux_cpf") String cpf,
            @PathVariable(value = "aux_dtNascimento") String dtNascimento,
            @PathVariable(value = "aux_ativo") Boolean ativo
    ) {
        //Treat error to Save
        try {
            socioService.save(name, endereco, telefone, sexo, cpf, dtNascimento, ativo);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            System.out.println(e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/socio/{aux_id}/{aux_nome}/{aux_endereco}/{aux_telefone}/{aux_sexo}/{aux_cpf}/{aux_dtNascimento}/{aux_ativo}")
    public ResponseEntity attSocio(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_nome") String name,
            @PathVariable(value = "aux_endereco") String endereco,
            @PathVariable(value = "aux_telefone") String telefone,
            @PathVariable(value = "aux_sexo") String sexo,
            @PathVariable(value = "aux_cpf") String cpf,
            @PathVariable(value = "aux_dtNascimento") String dtNascimento,
            @PathVariable(value = "aux_ativo") Boolean ativo
    ) {
        //Treat error to Save
        try {
            socioService.update(id, name, endereco, telefone, sexo, cpf, dtNascimento, ativo);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/socio/{aux_id}")
    public ResponseEntity delSocio(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            socioService.delete(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
