package compasso.backend.dto;


import javax.validation.constraints.NotBlank;

public class CidadeDTO {

    @NotBlank(message = "Campo Obrigatório")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    private String estado;

    public CidadeDTO() {
    }

    public CidadeDTO(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
