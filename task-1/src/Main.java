import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Number length reading
        System.out.print("Выберите длину последовательности (от 3 до 6): ");
        Scanner sc = new Scanner(System.in);
        int size = 0;
        try {
            size = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Неверный ввод.");
            return;
        }
        if (size > 6 || size < 3) {
            System.out.print("Неверная длина.");
            return;
        }
        // Creating random number array
        Utils utils = new Utils();
        LinkedList<Integer> array = utils.generateArray(size);
        System.out.println("Число загадано!");
        utils.printArray(array);
        // Game cycle
        boolean gameOver = false;
        byte attemptsLeft = (byte)(size * 3);
        while (!gameOver) {
            System.out.println("Осталось попыток: " + attemptsLeft);
            System.out.print("Введите число: ");
            String attempt = sc.next();
            if (attempt.length() != size || !utils.isStringNumber(attempt)) {
                System.out.println("Неверный ввод.");
                continue;
            }
            LinkedList<Integer> attemptNumbers = utils.stringToNumbers(attempt);
            if (!utils.areDigitsDifferent(attemptNumbers)) {
                System.out.println("Цифры числа должны быть различны.");
                continue;
            }

            Game game = new Game();

            int oxes = game.getOxesAmount(array, attemptNumbers);
            int cows = game.getCowsAndOxesAmount(array, attemptNumbers) - oxes;

            System.out.println("Быков: " + oxes + '\n' + "Коров: " + cows);

            if (oxes == size) {
                System.out.println("Вы победили!");
                gameOver = true;
            }
            --attemptsLeft;
            if (attemptsLeft == 0) {
                System.out.print("Игра окончена. Было загадано число ");
                utils.printArray(array);
                gameOver = true;
            }
        }
    }
}