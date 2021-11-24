package server.locadora.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valor;
    private Date prazoDevolucao;

    public Classe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getPrazoDevolucao() {
        return prazoDevolucao;
    }

    public void setPrazoDevolucao(Date prazoDevolucao) {
        this.prazoDevolucao = prazoDevolucao;
    }
}
