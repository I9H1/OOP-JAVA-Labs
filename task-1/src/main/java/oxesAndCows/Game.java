package oxesAndCows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Game {

    private int attemptsLeft = 0;
    private boolean gameOver = false;
    private final ResultContext result = new ResultContext();
    private boolean win = false;
    private boolean lost = false;
    private String number;

    public Status start(int size) {
        if (size < 3 || size > 6) {
            return Status.WRONG_LENGTH;
        }
        number = generateNumber(size);
        attemptsLeft = size * 3;
        return Status.SUCCESS;
    }

    public ResultContext guess(String guess) {
        result.status = validate(guess);
        if (result.status == Status.SUCCESS) {
            result.cows = getCows(guess);
            result.oxes = getOxes(guess);
            --attemptsLeft;
            if (result.oxes == number.length()) {
                gameOver = true;
                win = true;
            } else if (attemptsLeft == 0) {
                gameOver = true;
                lost = true;
            }
        }
        result.errorMessage = getMessage(result.status);
        return result;
    }

    private Status validate(String guess) {
        Validator validator = new Validator();
        validator.checkIfIsNumber(guess);
        validator.checkLength(guess, number.length());
        validator.checkForRepeats(guess);
        return validator.getStatus();
    }

    private String generateNumber(int size) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> digits = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            digits.add(i);
        }
        int numbersLeft = digits.size();
        Random rand = new Random();
        for (int i = 0; i < size; ++i) {
            int index = rand.nextInt(numbersLeft);
            sb.append(digits.get(index));
            digits.remove(index);
            --numbersLeft;
        }
        return sb.toString();
    }

    private String getMessage(Status status) {
        return switch (status) {
            case WRONG_LENGTH -> "Wrong length.";
            case NOT_A_NUMBER -> "Not a number.";
            case REPEATS_ERROR -> "Digits should not be repeated.";
            default -> "";
        };
    }

    private int getCows(String guess) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < number.length(); ++i) {
            map.put(number.charAt(i), true);
        }
        int cows_count = 0;
        for (int i = 0; i < number.length(); ++i) {
            boolean isInNumber = map.get(guess.charAt(i)) != null;
            if (guess.charAt(i) != number.charAt(i) && isInNumber) {
                ++cows_count;
            }
        }
        return cows_count;
    }

    private int getOxes(String guess) {
        int oxes_count = 0;
        for (int i = 0; i < number.length(); ++i) {
            if (guess.charAt(i) == number.charAt(i)) {
                ++oxes_count;
            }
        }
        return oxes_count;
    }

    public String getNumber() {
        return number;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isLoss() {
        return lost;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
