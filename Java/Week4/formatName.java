import java.util.Scanner;

public class formatName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name (FIRST.MIDDLE.LAST): ");
        String name = scanner.nextLine();

        String[] parts = name.split("\\.");
        String firstName = parts[0];
        String middleName = parts[1];
        String lastName = parts[2];
        String formattedName = String.format("%s, %s %c.", lastName, firstName, middleName.charAt(0));

        System.out.println("Formatted Name: " + formattedName);

        scanner.close();
    }
}
