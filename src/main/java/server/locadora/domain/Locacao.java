package server.locadora.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //@ManyToOne
    //private Cliente client;
    @ManyToOne
    private Socio socio;
    @ManyToOne
    private Dependente dependente;
    @ManyToOne
    private Titulo titulo;
    private Date dtLocacao;
    private Date dtDevolucaoPrevista;
    private Date dtDevolucaoEfetiva;
    private Double valorCobrado;
    private Double multaCobrada;

    public Locacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClient() {
        return socio != null ? socio : dependente != null ? dependente : null;
    }

    public void setClient(Socio socio) {
        this.socio = socio;
    }

    public void setClient(Dependente dependente) {
        this.dependente = dependente;
    }

    //public void setClient(Cliente client) {
    //    this.client = client;
    //}

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public Date getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public Date getDtDevolucaoPrevista() {
        return dtDevolucaoPrevista;
    }

    public void setDtDevolucaoPrevista(Date dtDevolucaoPrevista) {
        this.dtDevolucaoPrevista = dtDevolucaoPrevista;
    }

    public Date getDtDevolucaoEfetiva() {
        return dtDevolucaoEfetiva;
    }

    public void setDtDevolucaoEfetiva(Date dtDevolucaoEfetiva) {
        this.dtDevolucaoEfetiva = dtDevolucaoEfetiva;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Double getMultaCobrada() {
        return multaCobrada;
    }

    public void setMultaCobrada(Double multaCobrada) {
        this.multaCobrada = multaCobrada;
    }
}
