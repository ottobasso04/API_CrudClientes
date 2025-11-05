package org.example.Models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable // 1. Define esta classe como "embutível"
public class Endereco {

    @NotBlank(message = "O CEP é obrigatório")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 dígitos (apenas números)")
    private String cep;

    @NotBlank(message = "O logradouro é obrigatório")
    private String logradouro;

    private String complemento;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "A localidade (cidade) é obrigatória")
    private String localidade;

    @NotBlank(message = "A UF (estado) é obrigatória")
    @Size(min = 2, max = 2, message = "A UF deve ter 2 caracteres")
    private String uf;

    public Endereco() {
    }


    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
}
