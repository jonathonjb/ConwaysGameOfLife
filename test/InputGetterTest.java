import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputGetterTest extends InputGetter{
    @Test
    public void testSizeVerifier(){
        assertFalse(InputGetter.checkIfSizeInputIsValid("hi"));
        assertFalse(InputGetter.checkIfSizeInputIsValid("100000"));
        assertFalse(InputGetter.checkIfSizeInputIsValid("51"));
        assertFalse(InputGetter.checkIfSizeInputIsValid("0"));
        assertFalse(InputGetter.checkIfSizeInputIsValid("-100000"));

        assertTrue(InputGetter.checkIfSizeInputIsValid("1"));
        assertTrue(InputGetter.checkIfSizeInputIsValid("50"));
        assertTrue(InputGetter.checkIfSizeInputIsValid("34"));
    }
}