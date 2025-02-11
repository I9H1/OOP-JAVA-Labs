import java.util.LinkedList;
import java.util.Random;

public class Utils {
    public static void printArray(LinkedList<Integer> array) {
        for (byte i = 0; i < array.size(); ++i) {
            System.out.print(array.get(i));
        }
        System.out.println();
    }

    public static boolean areDigitsDifferent(LinkedList<Integer> array) {
        boolean[] map = new boolean[10];
        for (byte i = 0; i < array.size(); ++i) {
            if (map[array.get(i)]) {
                return false;
            } else {
                map[array.get(i)] = true;
            }
        }
        return true;
    }

    public static LinkedList<Integer> generateArray(int size) {
        LinkedList<Integer> array = new LinkedList<>();
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            numbers.add(i);
        }
        int numbersLeft = numbers.size();
        Random rand = new Random();
        for (int i = 0; i < size; ++i) {
            int index = rand.nextInt(numbersLeft);
            array.add(numbers.get(index));
            numbers.remove(index);
            --numbersLeft;
        }
        return array;
    }

    public static LinkedList<Integer> stringToNumbers(String string) {
        LinkedList<Integer> attemptNumbers = new LinkedList<>();
        for (byte i = 0; i < string.length(); ++i) {
            attemptNumbers.add(((int) string.charAt(i)) - (int)('0'));
        }
        return attemptNumbers;
    }

    public static boolean isStringNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
