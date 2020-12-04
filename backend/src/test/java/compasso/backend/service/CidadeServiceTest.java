package compasso.backend.service;

import compasso.backend.dto.CidadeDTO;
import compasso.backend.exception.GenericException;
import compasso.backend.model.Cidade;
import compasso.backend.repository.CidadeRepository;
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

@ExtendWith(MockitoExtension.class)
public class CidadeServiceTest {

    @InjectMocks
    private CidadeService cidadeService;

    @Mock
    private CidadeRepository cidadeRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void save_shouldReturnResponseEntity() {
        CidadeDTO param = new CidadeDTO();
        param.setNome("nome");
        param.setEstado("estado");

        Cidade mock = new Cidade();
        mock.setNome(param.getNome());
        mock.setEstado(param.getEstado());

        Mockito.when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(mock);
        Mockito.when(cidadeRepository.save(Mockito.any())).thenReturn(mock);

        Assertions.assertEquals(ResponseEntity.class, cidadeService.save(param).getClass());
        Assertions.assertEquals(Cidade.class, cidadeService.save(param).getBody().getClass());
        Assertions.assertEquals(HttpStatus.OK, cidadeService.save(param).getStatusCode());
    }

    @Test
    void save_shouldThrowCidadeException() {
        CidadeDTO param = new CidadeDTO();
        param.setNome("nome");
        param.setEstado("estado");

        Mockito.when(mapper.map(Mockito.any(), Mockito.any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(GenericException.class,() -> cidadeService.save(param));
    }

    @Test
    void filter_shouldThrowCidadeException() {
        Mockito.when(cidadeRepository.filter(Mockito.any(), Mockito.any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(GenericException.class,() -> cidadeService.filter("nome", "estado"));
    }
}
