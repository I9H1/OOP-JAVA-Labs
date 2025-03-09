package oxesAndCows;

import java.util.HashMap;
import java.util.Map;

public class Validator {

    private Status status = Status.SUCCESS;

    public void checkIfIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            status = Status.NOT_A_NUMBER;
        }
    }

    public void checkLength(String number, int length) {
        if (number.length() != length) {
            status = Status.WRONG_LENGTH;
        }
    }

    public void checkForRepeats(String number) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : number.toCharArray()) {
            if (map.containsKey(c)) {
                status = Status.REPEATS_ERROR;
                return;
            } else {
                map.put(c, true);
            }
        }
    }

    public Status getStatus() {
        return status;
    }
}
