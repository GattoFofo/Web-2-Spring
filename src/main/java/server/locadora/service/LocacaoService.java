package server.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.locadora.domain.*;
import server.locadora.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;
    @Autowired
    private TituloRepository tituloRepository;
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private DependenteRepository dependenteRepository;

    public List<Locacao> getLocacaoes() {
        return locacaoRepository.findAll();
    }

    public void save(Long clientId, Long tituloId, String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva, Double valorCobrado, Double multaCobrada) throws IllegalArgumentException, ParseException {
        //Create save Object
        Locacao locacao = new Locacao();

        //Cliente cliente = this.clienteRepository.findById(clientId).orElse(null);
        Socio socio = this.socioRepository.findById(clientId).orElse(null);
        Dependente dependente = this.dependenteRepository.findById(clientId).orElse(null);
        Titulo titulo = this.tituloRepository.findById(tituloId).orElse(null);

        if ((socio == null) && (dependente == null) || (titulo == null))
            throw new java.lang.RuntimeException("socio: " + socio + "\ndependente: " + dependente + "\ntitulo: " + titulo + "\nnull value error");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


        locacao.setClient(socio);
        locacao.setClient(dependente);
        locacao.setTitulo(titulo);
        locacao.setDtLocacao(dateFormat.parse(dtLocacao));
        locacao.setDtDevolucaoPrevista(dateFormat.parse(dtDevolucaoPrevista));
        locacao.setDtDevolucaoEfetiva(dateFormat.parse(dtDevolucaoEfetiva));
        locacao.setValorCobrado(valorCobrado);
        locacao.setMultaCobrada(multaCobrada);

        this.locacaoRepository.save(locacao);
    }

    public void update(Long id, String dtLocacao, String dtDevolucaoPrevista, String dtDevolucaoEfetiva, Double valorCobrado, Double multaCobrada) throws IllegalArgumentException, ParseException {
        Locacao locacao = this.locacaoRepository.findById(id).orElse(null);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        locacao.setDtLocacao(dateFormat.parse(dtLocacao));
        locacao.setDtDevolucaoPrevista(dateFormat.parse(dtDevolucaoPrevista));
        locacao.setDtDevolucaoEfetiva(dateFormat.parse(dtDevolucaoEfetiva));
        locacao.setValorCobrado(valorCobrado);
        locacao.setMultaCobrada(multaCobrada);

        this.locacaoRepository.save(locacao);
    }

    public void delete(Long id) throws IllegalArgumentException {
        this.locacaoRepository.deleteById(id);
    }
}
