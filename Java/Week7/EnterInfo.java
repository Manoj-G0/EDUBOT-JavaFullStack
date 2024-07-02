import java.util.Scanner;

class BlankNameException extends Exception {
    public BlankNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class EnterInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter your name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    throw new BlankNameException("Name cannot be blank.");
                }

                System.out.print("Enter your age: ");
                String ageStr = scanner.nextLine();
                age = Integer.parseInt(ageStr);

                if (age <= 0 || age > 120) {
                    throw new InvalidAgeException("Age must be between 1 and 120.");
                }

                validInput = true; // If no exceptions are thrown, input is valid

            } catch (BlankNameException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Please enter a valid integer.");
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        scanner.close();
    }
}
