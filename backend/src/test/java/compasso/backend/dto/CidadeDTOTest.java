package compasso.backend.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class CidadeDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void CidadeDTO_shouldNotHasConstraintViolation() {
        CidadeDTO param = new CidadeDTO();
        param.setNome("nome");
        param.setEstado("estado");

        Set<ConstraintViolation<CidadeDTO>> violations = validator.validate(param);

        Assertions.assertEquals(0, violations.size());
    }

    @Test
    void CidadeDTO_shouldHasConstraintViolation() {
        CidadeDTO param = new CidadeDTO();

        Set<ConstraintViolation<CidadeDTO>> violations = validator.validate(param);

        Assertions.assertTrue(violations.size() > 0);
    }
}
