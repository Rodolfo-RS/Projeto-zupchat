package br.com.zup.ZupChat.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @Column(unique = true, nullable = false)
    @Email(message = "Email inválido")
    private String email;

    @Min(value = 2, message = "Valor não permitido")
    @Max(value = 20, message = "Valor não permitido")
    private String nome;

    @Min(value = 5, message = "Valor não permitido")
    @Max(value = 20, message = "Valor não permitido")
    private String sobrenome;
    private String telefone;
    private String cargo;


    @OneToMany(mappedBy = "contato")
    private Set<Mensagem> mensagens;

    public Set<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Set<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
