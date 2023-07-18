import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import am.ik.yavi.core.ConstraintViolations;
import dto.NestedObject;
import dto.RootObject;
import org.junit.jupiter.api.Test;
import validators.Validators;

public class ValidatorTest {

    @Test
    void rootValidator_Should_FailFast() {
        // Arrange
        RootObject object = new RootObject("null", new NestedObject("string", true));

        // Act
        ConstraintViolations actual = Validators.rootValidator.validate(object);

        // Assert
        assertFalse(actual.isValid());
        assertEquals(actual.size(), 1);
    }

    @Test
    void nestedValidator_Should_FailFast() {
        // Arrange
        NestedObject object = new NestedObject(null, true);

        // Act
        ConstraintViolations actual = Validators.nestedValidator.validate(object);

        // Assert
        assertFalse(actual.isValid());
        assertEquals(actual.size(), 1);
    }
}
