package org.example.Models;



import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Para definir o nome da tabela
import jakarta.validation.Valid; // Para validar o objeto Endereco
import jakarta.validation.constraints.NotBlank; // Para validação de strings
import jakarta.validation.constraints.Size;    // Para validação de tamanho

@Entity
@Table(name = "clientes")
public class ClienteRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos (apenas números)")
    private String cpf;

    @Embedded
    @Valid
    private Endereco endereco;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(min = 10, message = "O telefone deve ter no mínimo 10 dígitos")
    private String telefone;

    public ClienteRequest() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}