package oxesAndCows;

import java.util.LinkedList;

public class Game {
    public int getCowsAndOxesAmount(LinkedList<Integer> arrayA, LinkedList<Integer> arrayB) {
        int counter = 0;
        boolean[] map = new boolean[10];
        for (int i : arrayA) {
            map[i] = true;
        }
        for (int i : arrayB) {
            if (map[i]) {
                ++counter;
            }
        }
        return counter;
    }

    public int getOxesAmount(LinkedList<Integer> arrayA, LinkedList<Integer> arrayB) {
        int counter = 0;
        for (byte i = 0; i < arrayA.size(); ++i) {
            if (arrayA.get(i).equals(arrayB.get(i))) {
                ++counter;
            }
        }
        return counter;
    }
}
