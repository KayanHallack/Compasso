package compasso.backend.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class NomeDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void NomeDTO_shouldNotHasConstraintViolation() {
        NomeDTO param = new NomeDTO();
        param.setNome("nome");

        Set<ConstraintViolation<NomeDTO>> violations = validator.validate(param);

        Assertions.assertEquals(0, violations.size());
    }

    @Test
    void NomeDTO_shouldHasConstraintViolation() {
        NomeDTO param = new NomeDTO();

        Set<ConstraintViolation<NomeDTO>> violations = validator.validate(param);

        Assertions.assertTrue(violations.size() > 0);
    }
}
