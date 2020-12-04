package compasso.backend.service;

import compasso.backend.dto.ClienteDTO;
import compasso.backend.exception.GenericException;
import compasso.backend.exception.ClienteNotFoundException;
import compasso.backend.model.Cidade;
import compasso.backend.model.Cliente;
import compasso.backend.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ModelMapper mapper;

    public ResponseEntity<Cliente> save(ClienteDTO dto) {
        try {
            Cliente cliente = mapper.map(dto, Cliente.class);
            cliente.setCidade(new Cidade(dto.getCidade()));
            return ResponseEntity.ok().body(clienteRepository.save(cliente));
        } catch (Exception e) {
            throw new GenericException();
        }
    }

    public ResponseEntity<Cliente> updateName(Integer id, String nome) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
        try {
            cliente.setNome(nome);
            clienteRepository.save(cliente);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new GenericException();
        }
    }

    public ResponseEntity<Cliente> delete(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
        try {
            clienteRepository.delete(cliente);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new GenericException();
        }
    }

    public ResponseEntity<List<ClienteDTO>> filter(Integer id, String nome) {
        try {
            return ResponseEntity.ok().body(clienteRepository.filter(id, nome));
        } catch (Exception e) {
            throw new GenericException();
        }
    }
}

