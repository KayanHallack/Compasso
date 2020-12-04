package compasso.backend.service;

import compasso.backend.dto.CidadeDTO;
import compasso.backend.exception.GenericException;
import compasso.backend.model.Cidade;
import compasso.backend.repository.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    private ModelMapper mapper;

    public ResponseEntity<Cidade> save(CidadeDTO dto) {
        try {
            Cidade cidade = mapper.map(dto, Cidade.class);
            return ResponseEntity.ok().body(cidadeRepository.save(cidade));
        } catch (Exception e) {
            throw new GenericException();
        }
    }

    public ResponseEntity<List<CidadeDTO>> filter(String nome, String estado) {
        try {
            return ResponseEntity.ok().body(cidadeRepository.filter(nome, estado));
        } catch (Exception e) {
            throw new GenericException();
        }
    }

}
