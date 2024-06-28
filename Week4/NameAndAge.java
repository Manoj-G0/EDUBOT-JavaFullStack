import java.util.Scanner;

public class NameAndAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your year of birth: ");
        int birthYear = scanner.nextInt();

        int nameLength = firstName.length();
        int currentYear = 2024; 
        int age = currentYear - birthYear;

        System.out.println("There are " + nameLength + " characters in " + firstName + "'s name");
        System.out.println(firstName + " will be " + age + " years old in " + currentYear);

        scanner.close();
    }
}
