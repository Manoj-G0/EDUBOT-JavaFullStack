import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Options");
        System.out.println("1. Equation A: 21 ÷ 3 + (3 × 9) × 9 + 5");
        System.out.println("2. Equation B: (17 - 7) × 6 + 2 + 56 - 8");
        System.out.println("3. Equation C: 10 + 8 × 90 ÷ 9 - 4");

        try {
            int option = Integer.parseInt(scanner.nextLine().trim());

            double result = 0.0;

            switch (option) {
                case 1:
                    result = 21.0 / 3 + (3 * 9) * 9 + 5;
                    System.out.printf("Result of equation A: %.1f\n", result);
                    break;
                case 2:
                    result = (17 - 7) * 6 + 2 + 56 - 8;
                    System.out.printf("Result of equation B: %.1f\n", result);
                    break;
                case 3:
                    result = 10 + 8 * 90.0 / 9 - 4;
                    System.out.printf("Result of equation C: %.1f\n", result);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

        scanner.close();
    }
}
