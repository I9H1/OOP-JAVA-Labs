package oxesAndCows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Number length reading
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose number length (from 3 to 6): ");
        int size;
        try {
            size = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Wrong input.");
            return;
        }
        // Creating random number
        Game game = new Game();
        if (game.start(size) != Status.SUCCESS) {
            System.out.println("Wrong size.");
            return;
        }
        // Game process
        ResultContext result;
        while (!game.isGameOver()) {
            System.out.println("Attempts left: " + game.getAttemptsLeft());
            System.out.print("Enter the number: ");
            result = game.guess(sc.next());
            if (result.status != Status.SUCCESS) {
                System.out.println(result.errorMessage);
                continue;
            }
            System.out.println("Oxes: " + result.oxes + '\n' + "Cows: " + result.cows);
            System.out.println();
            if (game.isWin()) {
                System.out.println("You won!");
            }
            if (game.isLoss()) {
                System.out.println("Game over. The number was " + game.getNumber() + ".");
            }
        }
    }
}