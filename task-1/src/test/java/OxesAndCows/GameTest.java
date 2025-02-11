package oxesAndCows;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void countOxes() {
        Game game = new Game();
        LinkedList<Integer> array1 = new LinkedList<>();
        LinkedList<Integer> array2 = new LinkedList<>();
        for (int i = 0; i < 5; ++i) {
            array1.add(i);
            array2.add(4 - i);
        }
        assertEquals(1, game.getOxesAmount(array1, array2));
    }

    @Test
    void noOxes() {
        Game game = new Game();
        LinkedList<Integer> array1 = new LinkedList<>();
        LinkedList<Integer> array2 = new LinkedList<>();
        for (int i = 0; i < 4; ++i) {
            array1.add(i);
            array2.add(3 - i);
        }
        assertEquals(0, game.getOxesAmount(array1, array2));
    }

    @Test
    void countOxesAndCows() {
        Game game = new Game();
        LinkedList<Integer> array1 = new LinkedList<>();
        LinkedList<Integer> array2 = new LinkedList<>();
        for (int i = 0; i < 5; ++i) {
            array1.add(i);
            array2.add(4 - i);
        }
        assertEquals(5, game.getCowsAndOxesAmount(array1, array2));
    }

    @Test
    void noOxesNorCows() {
        Game game = new Game();
        LinkedList<Integer> array1 = new LinkedList<>();
        LinkedList<Integer> array2 = new LinkedList<>();
        for (int i = 0; i < 4; ++i) {
            array1.add(i);
            array2.add(4 + i);
        }
        assertEquals(0, game.getCowsAndOxesAmount(array1, array2));
    }
}
