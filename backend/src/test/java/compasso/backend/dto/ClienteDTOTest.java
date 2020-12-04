package compasso.backend.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

public class ClienteDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void ClienteDTO_shouldNotHasConstraintViolation() {
        ClienteDTO param = new ClienteDTO();
        param.setNome("nome");
        param.setSexo("sexo");
        param.setNascimento(LocalDate.now());
        param.setIdade(1);
        param.setCidade(1);

        Set<ConstraintViolation<ClienteDTO>> violations = validator.validate(param);

        Assertions.assertEquals(0, violations.size());
    }

    @Test
    void ClienteDTO_shouldHasConstraintViolation() {
        ClienteDTO param = new ClienteDTO();

        Set<ConstraintViolation<ClienteDTO>> violations = validator.validate(param);

        Assertions.assertTrue(violations.size() > 0);
    }
}
