package compasso.backend.service;

import compasso.backend.dto.ClienteDTO;
import compasso.backend.exception.ClienteNotFoundException;
import compasso.backend.exception.GenericException;
import compasso.backend.model.Cidade;
import compasso.backend.model.Cliente;
import compasso.backend.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void save_shouldReturnResponseEntity() {
        ClienteDTO param = getClienteDTO();

        Cliente mock = new Cliente();
        mock.setNome(param.getNome());
        mock.setSexo(param.getSexo());
        mock.setNascimento(param.getNascimento());
        mock.setIdade(param.getIdade());
        mock.setCidade(new Cidade(param.getCidade()));

        Mockito.when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(mock);
        Mockito.when(clienteRepository.save(Mockito.any())).thenReturn(mock);

        Assertions.assertEquals(ResponseEntity.class, clienteService.save(param).getClass());
        Assertions.assertEquals(Cliente.class, clienteService.save(param).getBody().getClass());
        Assertions.assertEquals(HttpStatus.OK, clienteService.save(param).getStatusCode());
    }

    @Test
    void save_shouldThrowClienteException() {
        ClienteDTO param = getClienteDTO();

        Mockito.when(mapper.map(Mockito.any(), Mockito.any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(GenericException.class, () -> clienteService.save(param));
    }

    @Test
    void updateName_shouldReturnResponseEntity() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.of(new Cliente()));

        Assertions.assertEquals(ResponseEntity.class, clienteService.updateName(1, "nome").getClass());
        Assertions.assertEquals(null, clienteService.updateName(1, "nome").getBody());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, clienteService.updateName(1, "nome").getStatusCode());
    }

    @Test
    void updateName_shouldThrowClienteNotFoundException() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Assertions.assertThrows(ClienteNotFoundException.class, () -> clienteService.updateName(1, "nome"));
    }

    @Test
    void updateName_shouldThrowClienteException() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.of(new Cliente()));
        Mockito.when(clienteRepository.save(Mockito.any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(GenericException.class, () -> clienteService.updateName(1, "nome"));
    }

    @Test
    void delete_shouldReturnResponseEntity() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.of(new Cliente()));

        Assertions.assertEquals(ResponseEntity.class, clienteService.delete(1).getClass());
        Assertions.assertEquals(null, clienteService.delete(1).getBody());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, clienteService.delete(1).getStatusCode());
    }

    @Test
    void delete_shouldThrowClienteNotFoundException() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Assertions.assertThrows(ClienteNotFoundException.class, () -> clienteService.delete(1));
    }

    @Test
    void delete_shouldThrowClienteException() {
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(Optional.of(new Cliente()));
        Mockito.doThrow(new RuntimeException()).when(clienteRepository).delete(Mockito.any());

        Assertions.assertThrows(GenericException.class, () -> clienteService.delete(1));
    }

    @Test
    void filter_shouldThrowClienteException() {
        Mockito.when(clienteRepository.filter(Mockito.any(), Mockito.any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(GenericException.class, () -> clienteService.filter(1, "nome"));
    }

    private ClienteDTO getClienteDTO() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNome("nome");
        cliente.setSexo("sexo");
        cliente.setNascimento(LocalDate.now());
        cliente.setIdade(1);
        cliente.setCidade(1);

        return cliente;
    }
}
