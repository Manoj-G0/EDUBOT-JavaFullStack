import java.util.Scanner;

public class MyInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(",");
        if (parts.length != 4) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }

        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String ageStr = parts[2].trim();
        String city = parts[3].trim();
        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 1 || age >= 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }

        if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        System.out.printf("My Name is %s %s.%n", firstName, lastName);
        System.out.printf("I am %d years old and was born in %s%n", age, city);

        scanner.close();
    }
}
