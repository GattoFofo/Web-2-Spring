package server.locadora.domain;

import java.util.Date;

public abstract class Cliente {
    private Long nunInscricao;
    private String nome;
    private Date dtNascimento;
    private String sexo;
    private String cpf;
    private String endereco;
    private String telefone;
    private Boolean estahAtivo;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
