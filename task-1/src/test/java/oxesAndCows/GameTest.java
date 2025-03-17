package oxesAndCows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void GameStart() {
        Game game = new Game();
        assertEquals(Status.WRONG_LENGTH, game.start(2));
        assertEquals(Status.WRONG_LENGTH, game.start(7));
        assertEquals(Status.SUCCESS, game.start(4));
    }

    @Test
    void WrongLength() {
        Game game = new Game();
        game.start(3);
        ResultContext result = game.guess("1234");
        assertEquals(Status.WRONG_LENGTH, result.status);
    }

    @Test
    void NotNumber() {
        Game game = new Game();
        game.start(3);
        ResultContext result = game.guess("1a3");
        assertEquals(Status.NOT_A_NUMBER, result.status);
    }

    @Test
    void HasRepeats() {
        Game game = new Game();
        game.start(3);
        ResultContext result = game.guess("133");
        assertEquals(Status.REPEATS_ERROR, result.status);
    }

    @Test
    void GuessTest1() {
        Game game = new Game();
        game.start(3);
        game.setNumber("012");
        ResultContext result = game.guess("789");
        assertEquals(Status.SUCCESS, result.status);
        assertEquals(0, result.cows);
        assertEquals(0, result.oxes);
    }

    @Test
    void GuessTest2() {
        Game game = new Game();
        game.start(5);
        game.setNumber("01234");
        ResultContext result = game.guess("43210");
        assertEquals(Status.SUCCESS, result.status);
        assertEquals(4, result.cows);
        assertEquals(1, result.oxes);
    }

    @Test
    void GuessTest3() {
        Game game = new Game();
        game.start(6);
        game.setNumber("012345");
        ResultContext result = game.guess("012345");
        assertEquals(Status.SUCCESS, result.status);
        assertEquals(0, result.cows);
        assertEquals(6, result.oxes);
        assertEquals(true, game.isGameOver());
        assertEquals(true, game.isWin());
        assertEquals(false, game.isLoss());
    }

    @Test
    void GuessTest4() {
        Game game = new Game();
        game.start(3);
        game.setNumber("012");
        ResultContext result = game.guess("013");
        for (int i = 0; i < 8; ++i) {
            result = game.guess("013");
        }
        assertEquals(Status.SUCCESS, result.status);
        assertEquals(true, game.isGameOver());
        assertEquals(false, game.isWin());
        assertEquals(true, game.isLoss());
    }

}
