import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        final int MAX_ATTEMPTS = 10;

        System.out.println("Guess the number (between 1 and 100):");

        while (attempts < MAX_ATTEMPTS) {
            try {
                int guess = Integer.parseInt(scanner.nextLine());

                if (guess < 1 || guess > 100) {
                    System.out.println("Invalid Input");
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.printf("Congratulations! You guessed the number %d correctly in %d attempts.\n", secretNumber, attempts);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry! You lost the game.");
        }

        scanner.close();
    }
}
