package compasso.backend.repository;

import compasso.backend.dto.CidadeDTO;
import compasso.backend.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("SELECT new compasso.backend.dto.CidadeDTO(c.nome, c.estado) FROM Cidade c " +
            "WHERE (:nome IS NULL OR LOWER(c.nome) LIKE CONCAT('%', LOWER(:nome), '%')) " +
            "AND (:estado IS NULL OR LOWER(c.estado) LIKE CONCAT('%', LOWER(:estado), '%')) ")
    List<CidadeDTO> filter(@Param("nome") String nome, @Param("estado") String estado);
}
