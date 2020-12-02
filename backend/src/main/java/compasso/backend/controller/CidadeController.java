package compasso.backend.controller;

import compasso.backend.model.Cidade;
import compasso.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/cidade")
public class CidadeController {

    @Autowired
    CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<Cidade>> get(){
        return ResponseEntity.ok().body(cidadeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Cidade cidade){
        cidadeRepository.save(cidade);
        return ResponseEntity.ok().build();
    }
}
