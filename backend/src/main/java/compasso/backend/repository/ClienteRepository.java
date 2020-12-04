package compasso.backend.repository;

import compasso.backend.dto.CidadeDTO;
import compasso.backend.dto.ClienteDTO;
import compasso.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT new compasso.backend.dto.ClienteDTO(c.nome, c.sexo, c.nascimento, c.idade, c.cidade.id) FROM Cliente c " +
            "WHERE (:id IS NULL OR :id = c.id ) " +
            "AND (:nome IS NULL OR LOWER(c.nome) LIKE CONCAT('%', LOWER(:nome), '%')) ")
    List<ClienteDTO> filter(@Param("id") Integer id, @Param("nome") String nome);
}
