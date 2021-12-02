package server.locadora.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Cliente {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nunInscricao;
    private String nome;
    private Date dtNascimento;
    private String sexo;
    private Boolean estahAtivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNunInscricao() {
        return nunInscricao;
    }

    public void setNunInscricao(Long nunInscricao) {
        this.nunInscricao = nunInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getEstahAtivo() {
        return estahAtivo;
    }

    public void setEstahAtivo(Boolean estahAtivo) {
        this.estahAtivo = estahAtivo;
    }

}
