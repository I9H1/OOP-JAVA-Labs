package oxesAndCows;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void digitsArentDiff() {
        Utils utils = new Utils();
        LinkedList<Integer> array = new LinkedList<>();
        array.add(0);
        for (int i = 0; i < 5; ++i) {
            array.add(i);
        }
        assertFalse(utils.areDigitsDifferent(array));
    }

    @Test
    void digitsAreDiff() {
        Utils utils = new Utils();
        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < 5; ++i) {
            array.add(i);
        }
        assertTrue(utils.areDigitsDifferent(array));
    }

    @Test
    void stringIsntNumber() {
        Utils utils = new Utils();
        String string = "01a23";
        assertFalse(utils.isStringNumber(string));
    }

    @Test
    void stringIsNumber() {
        Utils utils = new Utils();
        String string = "0123";
        assertTrue(utils.isStringNumber(string));
    }

    @Test
    void stringToNum() {
        Utils utils = new Utils();
        String string = "0123";
        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < 4; ++i) {
            array.add(i);
        }
        assertEquals(array, utils.stringToNumbers(string));
    }
}
