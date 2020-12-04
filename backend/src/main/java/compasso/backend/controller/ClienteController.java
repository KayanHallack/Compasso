package compasso.backend.controller;

import compasso.backend.dto.ClienteDTO;
import compasso.backend.dto.NomeDTO;
import compasso.backend.model.Cliente;
import compasso.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
@Validated
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}/nome")
    public ResponseEntity<Cliente> updateName(@PathVariable("id") Integer id, @Valid @RequestBody NomeDTO dto) {
        return clienteService.updateName(id, dto.getNome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer id) {
        return clienteService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> filter(@RequestParam(required = false) Integer id,
                                                  @RequestParam(required = false) String nome) {
        return clienteService.filter(id, nome);
    }
}
