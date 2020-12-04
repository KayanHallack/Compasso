package compasso.backend.dto;

import javax.validation.constraints.NotEmpty;

public class NomeDTO {

    @NotEmpty(message = "Campo Obrigatório")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
