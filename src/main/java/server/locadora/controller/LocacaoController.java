package server.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.locadora.domain.Locacao;
import server.locadora.service.LocacaoService;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LocacaoController {
    @Autowired
    private LocacaoService locacaoService;

    @GetMapping(value = "/locacoes")
    public List<Locacao> getLocacaoes() {
        return locacaoService.getLocacaoes();
    }

    @PostMapping("/locacao/{aux_clientId}/{aux_tituloId}/{aux_dtLocacao}/{aux_dtDevolucaoPrevista}/{aux_dtDevolucaoEfetiva}/{aux_valorCobrado}/{aux_multaCobrada}")
    public ResponseEntity addLocacao(
            @PathVariable(value = "aux_clientId") Long clientId,
            @PathVariable(value = "aux_tituloId") Long tituloId,
            @PathVariable(value = "aux_dtLocacao") String dtLocacao,
            @PathVariable(value = "aux_dtDevolucaoPrevista") String dtDevolucaoPrevista,
            @PathVariable(value = "aux_dtDevolucaoEfetiva") String dtDevolucaoEfetiva,
            @PathVariable(value = "aux_valorCobrado") Double valorCobrado,
            @PathVariable(value = "aux_multaCobrada") Double multaCobrada
    ) {
        //Treat error to Save
        try {
            locacaoService.save(clientId, tituloId, dtLocacao, dtDevolucaoPrevista, dtDevolucaoEfetiva, valorCobrado, multaCobrada);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/locacao/{aux_id}/{aux_dtLocacao}/{aux_dtDevolucaoPrevista}/{aux_dtDevolucaoEfetiva}/{aux_valorCobrado}/{aux_multaCobrada}")
    public ResponseEntity attLocacao(
            @PathVariable(value = "aux_id") Long id,
            @PathVariable(value = "aux_dtLocacao") String dtLocacao,
            @PathVariable(value = "aux_dtDevolucaoPrevista") String dtDevolucaoPrevista,
            @PathVariable(value = "aux_dtDevolucaoEfetiva") String dtDevolucaoEfetiva,
            @PathVariable(value = "aux_valorCobrado") Double valorCobrado,
            @PathVariable(value = "aux_multaCobrada") Double multaCobrada
    ) {
        //Treat error to Save
        try {
            locacaoService.update(id, dtLocacao, dtDevolucaoPrevista, dtDevolucaoEfetiva, valorCobrado, multaCobrada);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/locacao/{aux_id}")
    public ResponseEntity delLocacao(
            @PathVariable(value = "aux_id") Long id
    ) {
        //Treat error to Save
        try {
            locacaoService.delete(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
