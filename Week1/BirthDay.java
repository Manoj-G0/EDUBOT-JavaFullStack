import java.util.Scanner;

public class BirthDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine().trim();
        String input2 = scanner.nextLine().trim();
        String[] parts1 = input1.split(",");
        if (parts1.length != 4) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        String name1 = parts1[0].trim();
        int month1, day1, year1;
        try {
            month1 = Integer.parseInt(parts1[1].trim());
            day1 = Integer.parseInt(parts1[2].trim());
            year1 = Integer.parseInt(parts1[3].trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        String[] parts2 = input2.split(",");
        if (parts2.length != 4) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        String name2 = parts2[0].trim();
        int month2, day2, year2;
        try {
            month2 = Integer.parseInt(parts2[1].trim());
            day2 = Integer.parseInt(parts2[2].trim());
            year2 = Integer.parseInt(parts2[3].trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        if (!isValidDate(month1, day1, year1) || !isValidDate(month2, day2, year2)) {
            System.out.println("Invalid Input");
            scanner.close();
            return;
        }
        System.out.printf("In the USA my birthday is: %02d/%02d/%04d%n", month1, day1, year1);
        System.out.printf("In England my birthday is: %02d/%02d/%04d%n", day1, month1, year1);
        System.out.printf("In the USA my friend %s's birthday is: %02d/%02d/%04d%n", name2, month2, day2, year2);
        System.out.printf("In England my friend %s's birthday is: %02d/%02d/%04d%n", name2, day2, month2, year2);

        scanner.close();
    }
    private static boolean isValidDate(int month, int day, int year) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1950 || year > 2024) {
            return false;
        }
        return true;
    }
}
