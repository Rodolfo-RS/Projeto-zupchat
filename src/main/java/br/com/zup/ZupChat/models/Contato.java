package br.com.zup.ZupChat.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @Column(unique = true, nullable = false)
    private String email;
    private String nome;
    private String telefone;

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
}
