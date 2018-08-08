package envepro.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotNull
    private String aniversario;

    @Pattern(message = "Campo telefone deve conter somente números",regexp = "([0-9])\\w+")
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();


    public Pessoa() {
    }

    public Pessoa(String nome, String aniversario, String telefone) {
        this.nome = nome;
        this.aniversario = aniversario;
        this.telefone = telefone;
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

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(aniversario, pessoa.aniversario) &&
                Objects.equals(telefone, pessoa.telefone) &&
                Objects.equals(enderecos, pessoa.enderecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, aniversario, telefone, enderecos);
    }
}


