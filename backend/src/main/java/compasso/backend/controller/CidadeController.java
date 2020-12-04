package compasso.backend.controller;

import compasso.backend.dto.CidadeDTO;
import compasso.backend.model.Cidade;
import compasso.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cidade")
@Validated
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> save(@Valid @RequestBody CidadeDTO cidade) {
        return cidadeService.save(cidade);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> filter(@RequestParam(required = false) String nome,
                                                  @RequestParam(required = false) String estado) {
        return cidadeService.filter(nome, estado);
    }
}
