package compasso.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {

    @NotBlank(message = "Campo Obrigatório")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    private String sexo;
    @NotNull(message = "Campo Obrigatório")
    private LocalDate nascimento;
    @NotNull(message = "Campo Obrigatório")
    private Integer idade;
    @NotNull(message = "Campo Obrigatório")
    private Integer cidade;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String sexo, LocalDate nascimento, Integer idade, Integer cidade) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.idade = idade;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getCidade() {
        return cidade;
    }

    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }
}
