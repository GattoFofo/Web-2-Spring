package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Dependente;
import server.locadora.service.DependenteService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DependenteController {
    @Autowired
    private DependenteService dependenteService;

    @GetMapping(value = "/dependentes")
    public List<Dependente> getDependentes() {
        return dependenteService.getDependentes();
    }

    @PostMapping("/dependente/{aux_SocioId}/{aux_nome}/{aux_endereco}/{aux_tel}/{aux_sexo}/{aux_cpf}/{aux_dtNascimento}/{aux_ativo}")
    public ResponseEntity addDependente(
            @PathVariable(value = "aux_SocioId") Long socioId,
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
            dependenteService.save(socioId, name, endereco, telefone, sexo, cpf, dtNascimento, ativo);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/dependente/{aux_id}/{aux_nome}/{aux_endereco}/{aux_tel}/{aux_sexo}/{aux_cpf}/{aux_dtNascimento}/{aux_ativo}")
    public ResponseEntity attDependente(
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
            dependenteService.update(id, name, endereco, telefone, sexo, cpf, dtNascimento, ativo);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/dependente/{aux_SocioId}/{aux_id}")
    public ResponseEntity delDependente(
            @PathVariable(value = "aux_SocioId") Long socioId,
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            dependenteService.delete(socioId, id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
