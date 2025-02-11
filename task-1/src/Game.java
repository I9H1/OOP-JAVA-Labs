import java.util.LinkedList;

public class Game {
    public static int getCowsAndOxesAmount(LinkedList<Integer> arrayA, LinkedList<Integer> arrayB) {
        int counter = 0;
        boolean[] map = new boolean[10];
        for (byte i = 0; i < arrayA.size(); ++i) {
            map[arrayA.get(i)] = true;
        }
        for (byte i = 0; i < arrayB.size(); ++i) {
            if (map[arrayB.get(i)]) {
                ++counter;
            }
        }
        return counter;
    }

    public static int getOxesAmount(LinkedList<Integer> arrayA, LinkedList<Integer> arrayB) {
        int counter = 0;
        for (byte i = 0; i < arrayA.size(); ++i) {
            if (arrayA.get(i) == arrayB.get(i)) {
                ++counter;
            }
        }
        return counter;
    }
}
